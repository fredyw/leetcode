// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
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

pub fn kth_largest_level_sum(root: Option<Rc<RefCell<TreeNode>>>, k: i32) -> i64 {
    todo!()
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

    let root = Some(Rc::new(RefCell::new(TreeNode::new(5))));
    let left = add_left(&root, 8);
    let right = add_right(&root, 9);
    add_left(&right, 3);
    add_right(&right, 7);
    let left = add_left(&left, 2);
    add_right(&left, 1);
    add_left(&left, 4);
    add_right(&left, 6);

    println!("{}", kth_largest_level_sum(root, 2)); // 13

    let root = Some(Rc::new(RefCell::new(TreeNode::new(5))));
    let left = add_left(&root, 2);
    add_left(&left, 3);
    println!("{}", kth_largest_level_sum(root, 1)); // 3
}
