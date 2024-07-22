use std::cell::RefCell;
use std::collections::VecDeque;
use std::ptr::null;
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

// https://leetcode.com/problems/largest-bst-subtree/description/
pub fn largest_bst_subtree(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
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
        largest_bst_subtree(to_tree(vec![
            Some(10),
            Some(5),
            Some(15),
            Some(1),
            Some(8),
            None,
            Some(7)
        ]))
    ); // 3
    println!(
        "{}",
        largest_bst_subtree(to_tree(vec![
            Some(4),
            Some(2),
            Some(7),
            Some(2),
            Some(3),
            Some(5),
            None,
            Some(2),
            None,
            None,
            None,
            None,
            None,
            Some(1)
        ]))
    ); // 2
    println!("{}", largest_bst_subtree(to_tree(vec![Some(1), Some(2)]))); // 1
    println!(
        "{}",
        largest_bst_subtree(to_tree(vec![Some(1), None, Some(2)]))
    ); // 2
}
