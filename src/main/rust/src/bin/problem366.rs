use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;

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

// https://leetcode.com/problems/find-leaves-of-binary-tree/description/
pub fn find_leaves(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
    fn dfs(root: Option<Rc<RefCell<TreeNode>>>, nodes: &mut Vec<(i32, i32)>) -> i32 {
        if root.is_none() {
            return 0;
        }
        let left = dfs(root.as_ref().unwrap().borrow().left.clone(), nodes);
        let right = dfs(root.as_ref().unwrap().borrow().right.clone(), nodes);
        let n = 1 + left.max(right);
        nodes.push((n, root.as_ref().unwrap().borrow().val));
        n
    }

    let mut nodes: Vec<(i32, i32)> = vec![];
    dfs(root, &mut nodes);
    nodes.sort();
    let mut answer: Vec<Vec<i32>> = vec![];
    let mut i = 0;
    while i < nodes.len() {
        let n = nodes[i].0;
        let mut v = vec![];
        while i < nodes.len() && nodes[i].0 == n {
            v.push(nodes[i].1);
            i += 1;
        }
        answer.push(v);
    }
    answer
}

fn create_node(value: i32) -> Option<Rc<RefCell<TreeNode>>> {
    Some(Rc::new(RefCell::new(TreeNode::new(value))))
}

fn add_left(parent: &Option<Rc<RefCell<TreeNode>>>, value: i32) -> Option<Rc<RefCell<TreeNode>>> {
    parent.as_ref().unwrap().borrow_mut().left = create_node(value);
    parent.as_ref().unwrap().borrow().left.clone()
}

fn add_right(parent: &Option<Rc<RefCell<TreeNode>>>, value: i32) -> Option<Rc<RefCell<TreeNode>>> {
    parent.as_ref().unwrap().borrow_mut().right = create_node(value);
    parent.as_ref().unwrap().borrow().right.clone()
}

fn to_tree(nodes: Vec<Option<i32>>) -> Option<Rc<RefCell<TreeNode>>> {
    if nodes.len() == 0 {
        return None;
    }
    let mut deque: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
    let root = create_node(nodes[0].unwrap());
    deque.push_back(root.clone());
    let mut i = 1;
    while i < nodes.len() {
        let parent = deque.pop_front().unwrap();
        let mut has_left = false;
        if let Some(left) = nodes[i] {
            deque.push_back(add_left(&parent, left));
            has_left = true;
        }
        let mut has_right = false;
        if i + 1 < nodes.len() {
            if let Some(right) = nodes[i + 1] {
                deque.push_back(add_right(&parent, right));
                has_right = true;
            }
        }
        if !has_left && !has_right {
            deque.push_back(parent);
        }
        i += 2;
    }
    root
}

fn main() {
    println!(
        "{:?}",
        find_leaves(to_tree(vec![Some(1), Some(2), Some(3), Some(4), Some(5)]))
    ); // [[4,5,3],[2],[1]]
    println!("{:?}", find_leaves(to_tree(vec![Some(1)]))); // [[1]]
    println!(
        "{:?}",
        find_leaves(to_tree(vec![
            Some(1),
            Some(2),
            Some(3),
            Some(4),
            Some(5),
            Some(6),
            None,
            Some(7),
            Some(8)
        ]))
    ); // [[7,8,5,6],[4,3],[2],[1]]
}
