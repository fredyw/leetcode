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

// https://leetcode.com/problems/construct-binary-tree-from-string/description/
pub fn str2tree(s: String) -> Option<Rc<RefCell<TreeNode>>> {
    todo!()
}

fn main() {
    println!("{:?}", str2tree("4(2(3)(1))(6(5))".to_string())); // [4,2,6,3,1,5]
    println!("{:?}", str2tree("4(2(3)(1))(6(5)(7))".to_string())); // [4,2,6,3,1,5,7]
    println!("{:?}", str2tree("-4(2(3)(1))(6(5)(7))".to_string())); // [-4,2,6,3,1,5,7]
}
