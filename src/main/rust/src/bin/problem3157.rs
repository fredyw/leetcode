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

// https://leetcode.com/problems/find-the-level-of-tree-with-minimum-sum/description/
pub fn minimum_level(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
    let mut answer = 0;
    let mut min_sum: i64 = 0;
    let mut deque: VecDeque<Rc<RefCell<TreeNode>>> = VecDeque::new();
    deque.push_back(root.unwrap());
    let mut level = 1;
    while !deque.is_empty() {
        let size = deque.len();
        let mut sum: i64 = 0;
        for _ in 0..size {
            if let Some(node) = deque.pop_front() {
                sum += node.borrow().val as i64;
                if let Some(left) = node.as_ref().borrow().left.clone() {
                    deque.push_back(left);
                }
                if let Some(right) = node.as_ref().borrow().right.clone() {
                    deque.push_back(right);
                }
            }
        }
        if level == 1 || min_sum > sum {
            answer = level;
            min_sum = sum;
        }
        level += 1;
    }
    answer
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
        let mut has_left = false;
        if let Some(left) = nodes[i] {
            deque.push_back(add_left(&parent, left));
            has_left = true;
        }
        let mut has_right = false;
        if i + 1 < nodes.len() {
            if let Some(right) = nodes[i + 1] {
                deque.push_back(add_right(&parent, right));
                has_right = true;
            }
        }
        if !has_left && !has_right {
            deque.push_back(parent);
        }
        i += 2;
    }
    root
}

fn main() {
    println!(
        "{}",
        minimum_level(to_tree(vec![
            Some(50),
            Some(6),
            Some(2),
            Some(30),
            Some(80),
            Some(7)
        ]))
    ); // 2
    println!(
        "{}",
        minimum_level(to_tree(vec![
            Some(36),
            Some(17),
            Some(10),
            None,
            None,
            Some(24)
        ]))
    ); // 3
    println!(
        "{}",
        minimum_level(to_tree(vec![Some(5), None, Some(5), None, Some(5)]))
    ); // 1
}
