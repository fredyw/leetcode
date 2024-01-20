// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
use std::cell::RefCell;
use std::collections::VecDeque;
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
    let mut sums = vec![];
    let mut deque: VecDeque<Rc<RefCell<TreeNode>>> = VecDeque::new();
    deque.push_back(root.unwrap());
    while !deque.is_empty() {
        let size = deque.len();
        let mut sum: i64 = 0;
        for _ in 0..size {
            let node = deque.pop_front();
            if let Some(node) = node {
                sum += node.as_ref().borrow().val as i64;
                if let Some(left) = node.as_ref().borrow().left.clone() {
                    deque.push_back(left);
                }
                if let Some(right) = node.as_ref().borrow().right.clone() {
                    deque.push_back(right);
                }
            }
        }
        sums.push(sum);
    }
    sums.sort_by(|a, b| b.cmp(a));
    if sums.len() < k as usize {
        -1
    } else {
        sums[k as usize - 1]
    }
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
    add_right(&left, 1);
    let left = add_left(&left, 2);
    add_left(&left, 4);
    add_right(&left, 6);
    println!("{}", kth_largest_level_sum(root, 2)); // 13

    let root = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    let left = add_left(&root, 2);
    add_left(&left, 3);
    println!("{}", kth_largest_level_sum(root, 1)); // 3
}
