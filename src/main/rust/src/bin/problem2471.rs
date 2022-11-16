// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
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

pub fn minimum_operations(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
    todo!()
}

fn main() {}
