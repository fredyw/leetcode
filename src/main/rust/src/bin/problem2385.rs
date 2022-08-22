use std::cell::RefCell;
use std::collections::{HashMap, HashSet, VecDeque};
use std::rc::Rc;

// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

pub fn amount_of_time(root: Option<Rc<RefCell<TreeNode>>>, start: i32) -> i32 {
    fn traverse(
        parent: i32,
        node: &Option<Rc<RefCell<TreeNode>>>,
        adj_list: &mut HashMap<i32, Vec<i32>>,
    ) {
        if let Some(n) = node {
            let val = n.as_ref().borrow().val;
            (*adj_list.entry(parent).or_insert(vec![])).push(val);
            (*adj_list.entry(val).or_insert(vec![])).push(parent);
            traverse(val, &n.as_ref().borrow().left, adj_list);
            traverse(val, &n.as_ref().borrow().right, adj_list);
        }
    }

    let root = root.unwrap();
    let root_val = root.as_ref().borrow().val;
    let mut adj_list: HashMap<i32, Vec<i32>> = HashMap::new();
    traverse(root_val, &root.as_ref().borrow().left, &mut adj_list);
    traverse(root_val, &root.as_ref().borrow().right, &mut adj_list);

    let mut answer = 0;
    let mut deque: VecDeque<i32> = VecDeque::new();
    let mut visited: HashSet<i32> = HashSet::new();
    deque.push_back(start);
    visited.insert(start);
    while !deque.is_empty() {
        let size = deque.len();
        answer += 1;
        for _ in 0..size {
            let n = deque.pop_front().unwrap();
            for adj in adj_list.get(&n).unwrap_or(&vec![]).iter() {
                if !visited.contains(&adj) {
                    deque.push_back(*adj);
                    visited.insert(*adj);
                }
            }
        }
    }
    if answer > 0 {
        answer - 1
    } else {
        0
    }
}

fn main() {
    fn add_left(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        parent.as_ref().unwrap().as_ref().borrow_mut().left =
            Some(Rc::new(RefCell::new(TreeNode::new(value))));
        parent.as_ref().unwrap().as_ref().borrow().left.clone()
    }
    fn add_right(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        parent.as_ref().unwrap().as_ref().borrow_mut().right =
            Some(Rc::new(RefCell::new(TreeNode::new(value))));
        parent.as_ref().unwrap().as_ref().borrow().right.clone()
    }

    let root = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    let parent = add_left(&root, 5);
    let parent = add_right(&parent, 4);
    add_left(&parent, 9);
    add_right(&parent, 2);
    let parent = add_right(&root, 3);
    add_left(&parent, 10);
    add_right(&parent, 6);
    println!("{}", amount_of_time(root, 3)); // 4

    let root = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    println!("{}", amount_of_time(root, 1)); // 0

    let root = Some(Rc::new(RefCell::new(TreeNode::new(2))));
    add_left(&root, 5);
    println!("{}", amount_of_time(root, 5)); // 1
}
