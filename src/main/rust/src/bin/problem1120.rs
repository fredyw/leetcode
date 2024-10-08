use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;

// https://leetcode.com/problems/maximum-average-subtree/description/
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

pub fn maximum_average_subtree(root: Option<Rc<RefCell<TreeNode>>>) -> f64 {
    fn maximum_average_subtree(
        root: Option<Rc<RefCell<TreeNode>>>,
        answer: &mut f64,
    ) -> (i32, i32) {
        if root.is_none() {
            return (0, 0);
        }
        let (left_count, left_sum) =
            maximum_average_subtree(root.as_ref().unwrap().borrow().left.clone(), answer);
        let (right_count, right_sum) =
            maximum_average_subtree(root.as_ref().unwrap().borrow().right.clone(), answer);
        let total_count = left_count + right_count + 1;
        let total_sum = left_sum + right_sum + root.as_ref().unwrap().borrow().val;
        *answer = answer.max(total_sum as f64 / total_count as f64);
        (total_count, total_sum)
    }

    let mut answer = 0.0;
    maximum_average_subtree(root, &mut answer);
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
        maximum_average_subtree(to_tree(vec![Some(5), Some(6), Some(1)]))
    ); // 6.00000
    println!(
        "{}",
        maximum_average_subtree(to_tree(vec![Some(0), None, Some(1)]))
    ); // 1.00000
}
