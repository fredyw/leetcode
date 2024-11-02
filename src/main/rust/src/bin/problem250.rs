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

// https://leetcode.com/problems/count-univalue-subtrees/
pub fn count_unival_subtrees(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
    fn f(root: Option<Rc<RefCell<TreeNode>>>, count: &mut i32) -> (Option<i32>, bool) {
        if let Some(root) = root {
            let val = root.as_ref().borrow().val;
            let (left_val, left_unival) = f(root.as_ref().borrow().left.clone(), count);
            let (right_val, right_unival) = f(root.as_ref().borrow().right.clone(), count);
            if left_unival && right_unival {
                if (left_val.is_some()
                    && right_val.is_some()
                    && left_val.unwrap() == right_val.unwrap()
                    && right_val.unwrap() == val)
                    || (left_val.is_some() && right_val.is_none() && left_val.unwrap() == val)
                    || (right_val.is_some() && left_val.is_none() && right_val.unwrap() == val)
                    || (left_val.is_none() && right_val.is_none())
                {
                    *count += 1;
                    (Some(val), true)
                } else {
                    (Some(val), false)
                }
            } else {
                (None, false)
            }
        } else {
            (None, true)
        }
    }

    let mut answer = 0;
    f(root, &mut answer);
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
        count_unival_subtrees(to_tree(vec![
            Some(5),
            Some(1),
            Some(5),
            Some(5),
            Some(5),
            None,
            Some(5)
        ]))
    ); // 4
    println!("{}", count_unival_subtrees(to_tree(vec![]))); // 0
    println!(
        "{}",
        count_unival_subtrees(to_tree(vec![
            Some(5),
            Some(5),
            Some(5),
            Some(5),
            Some(5),
            None,
            Some(5)
        ]))
    ); // 6
    println!(
        "{}",
        count_unival_subtrees(to_tree(vec![
            Some(5),
            Some(1),
            Some(5),
            Some(5),
            Some(5),
            None,
            Some(5)
        ]))
    ); // 4
    println!(
        "{}",
        count_unival_subtrees(to_tree(vec![Some(5), Some(5), Some(1)]))
    ); // 2
}
