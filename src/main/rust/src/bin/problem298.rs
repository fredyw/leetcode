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

// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/
pub fn longest_consecutive(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
    fn longest_consecutive(
        root: Option<Rc<RefCell<TreeNode>>>,
        next_value: i32,
        count: i32,
        max_count: &mut i32,
    ) {
        if let Some(n) = root {
            let val = n.borrow().val;
            let new_count = if val == next_value { count + 1 } else { 1 };
            *max_count = (*max_count).max(new_count);
            longest_consecutive(n.borrow_mut().left.clone(), val + 1, new_count, max_count);
            longest_consecutive(n.borrow_mut().right.clone(), val + 1, new_count, max_count);
        } else {
            *max_count = (*max_count).max(count);
        }
    }

    let mut answer = 0;
    let val = root.as_ref().unwrap().borrow().val;
    longest_consecutive(root, val, 0, &mut answer);
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
        if let Some(left) = nodes[i] {
            deque.push_back(add_left(&parent, left));
        }
        if i + 1 < nodes.len() {
            if let Some(right) = nodes[i + 1] {
                deque.push_back(add_right(&parent, right));
            }
        }
        i += 2;
    }
    root
}

fn main() {
    println!(
        "{}",
        longest_consecutive(to_tree(vec![
            Some(1),
            None,
            Some(3),
            Some(2),
            Some(4),
            None,
            None,
            None,
            Some(5)
        ]))
    ); // 3
    println!(
        "{}",
        longest_consecutive(to_tree(vec![
            Some(2),
            None,
            Some(3),
            Some(2),
            None,
            Some(1)
        ]))
    ); // 2
}
