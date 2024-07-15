use std::cell::RefCell;
use std::collections::VecDeque;
use std::ptr::{eq, null};
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

// https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants/description/
pub fn equal_to_descendants(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
    todo!()
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
        if let Some(left) = nodes[i] {
            deque.push_back(add_left(&parent, left));
        }
        if i + 1 < nodes.len() {
            if let Some(right) = nodes[i + 1] {
                deque.push_back(add_right(&parent, right));
            }
        }
        i += 2;
    }
    root
}

fn main() {
    println!(
        "{}",
        equal_to_descendants(to_tree(vec![Some(10), Some(3), Some(4), Some(2), Some(1)]))
    ); // 2
    println!(
        "{}",
        equal_to_descendants(to_tree(vec![Some(2), Some(3), None, Some(2), None]))
    ); // 0
    println!("{}", equal_to_descendants(to_tree(vec![Some(0)]))); // 1
}
