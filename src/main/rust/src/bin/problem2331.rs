// https://leetcode.com/problems/evaluate-boolean-binary-tree/
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

pub fn evaluate_tree(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
    fn f(root: &Option<Rc<RefCell<TreeNode>>>) -> Option<bool> {
        match root {
            Some(a) => {
                let value = a.as_ref().borrow().val;
                let left = f(&a.as_ref().borrow().left.clone());
                let right = f(&a.as_ref().borrow().right.clone());
                if left.is_none() && right.is_none() {
                    return Some(value != 0);
                }
                if value == 2 {
                    return Some(left.unwrap() || right.unwrap());
                }
                return Some(left.unwrap() && right.unwrap());
            }
            None => None,
        }
    }

    f(&root).unwrap()
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

    let root = Some(Rc::new(RefCell::new(TreeNode::new(2))));
    add_left(&root, 1);
    let right = add_right(&root, 3);
    add_left(&right, 0);
    add_right(&right, 1);
    println!("{}", evaluate_tree(root)); // true
    println!(
        "{}",
        evaluate_tree(Some(Rc::new(RefCell::new(TreeNode::new(0)))))
    ); // false
}
