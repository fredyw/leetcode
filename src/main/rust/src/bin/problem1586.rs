use std::cell::RefCell;
use std::rc::Rc;

// https://leetcode.com/problems/binary-search-tree-iterator-ii/description/
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

struct BSTIterator {}

impl BSTIterator {
    fn new(root: Option<Rc<RefCell<TreeNode>>>) -> Self {
        Self {}
    }

    fn has_next(&self) -> bool {
        todo!()
    }

    fn next(&self) -> i32 {
        todo!()
    }

    fn has_prev(&self) -> bool {
        todo!()
    }

    fn prev(&self) -> i32 {
        todo!()
    }
}

fn main() {}
