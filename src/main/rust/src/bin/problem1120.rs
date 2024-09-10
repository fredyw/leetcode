use std::cell::RefCell;
use std::rc::Rc;

// https://leetcode.com/problems/maximum-average-subtree/description/
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

pub fn maximum_average_subtree(root: Option<Rc<RefCell<TreeNode>>>) -> f64 {
    todo!()
}

fn main() {}
