use std::cell::RefCell;
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

// https://leetcode.com/problems/find-distance-in-a-binary-tree/description/
pub fn find_distance(root: Option<Rc<RefCell<TreeNode>>>, p: i32, q: i32) -> i32 {
    todo!()
}

fn main() {}
