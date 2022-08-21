use std::cell::RefCell;
use std::rc::Rc;

// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
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

pub fn amount_of_time(root: Option<Rc<RefCell<TreeNode>>>, start: i32) -> i32 {
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

    let root = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    let parent = add_left(&root, 5);
    let parent = add_right(&parent, 4);
    add_left(&parent, 9);
    add_right(&parent, 2);
    let parent = add_right(&root, 3);
    add_left(&parent, 10);
    add_right(&parent, 6);
    println!("{}", amount_of_time(root, 3)); // 4

    let root = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    println!("{}", amount_of_time(root, 1)); // 0
}
