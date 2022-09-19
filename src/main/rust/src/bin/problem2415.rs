use std::cell::RefCell;
use std::collections::VecDeque;
use std::mem::swap;
use std::rc::Rc;

// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
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

pub fn reverse_odd_levels(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
    let mut level = 0;
    let mut deque: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
    deque.push_back(root.clone());
    while !deque.is_empty() {
        let size = deque.len();
        let mut tmp: Vec<Option<Rc<RefCell<TreeNode>>>> = vec![];
        for _ in 0..size {
            let node = deque.pop_front().unwrap().clone();
            tmp.push(node.clone());
            if let Some(n) = node {
                let left = n.as_ref().borrow().left.clone();
                if left.is_some() {
                    deque.push_back(left);
                }
                let right = n.as_ref().borrow().right.clone();
                if right.is_some() {
                    deque.push_back(right);
                }
            }
        }
        if level % 2 != 0 {
            let mut i = 0;
            let mut j = tmp.len() - 1;
            while i < j {
                swap(
                    &mut tmp
                        .get(i)
                        .unwrap()
                        .clone()
                        .unwrap()
                        .as_ref()
                        .borrow_mut()
                        .val,
                    &mut tmp
                        .get(j)
                        .unwrap()
                        .clone()
                        .unwrap()
                        .as_ref()
                        .borrow_mut()
                        .val,
                );
                i += 1;
                j -= 1;
            }
        }
        level += 1;
    }
    root
}

fn main() {
    fn create_node(value: i32) -> Option<Rc<RefCell<TreeNode>>> {
        Some(Rc::new(RefCell::new(TreeNode::new(value))))
    }

    fn add_left(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        parent.as_ref().unwrap().as_ref().borrow_mut().left = create_node(value);
        parent.as_ref().unwrap().as_ref().borrow().left.clone()
    }

    fn add_right(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        parent.as_ref().unwrap().as_ref().borrow_mut().right = create_node(value);
        parent.as_ref().unwrap().as_ref().borrow().right.clone()
    }

    fn to_tree(nodes: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        let mut deque: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
        let root = create_node(nodes[0]);
        deque.push_back(root.clone());
        let mut i = 1;
        while i < nodes.len() {
            let parent = deque.pop_front().unwrap();
            deque.push_back(add_left(&parent, nodes[i]));
            deque.push_back(add_right(&parent, nodes[i + 1]));
            i += 2;
        }
        root
    }

    let root = to_tree(vec![2, 3, 5, 8, 13, 21, 34]);
    println!("{:?}", reverse_odd_levels(root)); // [2,5,3,8,13,21,34]

    let root = to_tree(vec![7, 13, 11]);
    println!("{:?}", reverse_odd_levels(root)); // [7,11,13]

    let root = to_tree(vec![0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2]);
    println!("{:?}", reverse_odd_levels(root)); // [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]

    let root = to_tree(vec![0, 1, 2, 0, 0, 0, 0, 6, 7, 8, 9, 1, 2, 3, 4]);
    println!("{:?}", reverse_odd_levels(root)); // [0,2,1,0,0,0,0,4,3,2,1,9,8,7,6]
}
