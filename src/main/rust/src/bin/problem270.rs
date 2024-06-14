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

// https://leetcode.com/problems/closest-binary-search-tree-value/
pub fn closest_value(root: Option<Rc<RefCell<TreeNode>>>, target: f64) -> i32 {
    todo!()
}

fn main() {
    fn create_node(value: i32) -> Option<Rc<RefCell<TreeNode>>> {
        Some(Rc::new(RefCell::new(TreeNode::new(value))))
    }

    fn add_left(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        parent.as_ref().unwrap().borrow_mut().left = create_node(value);
        parent.as_ref().unwrap().borrow().left.clone()
    }

    fn add_right(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
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

    println!(
        "{}",
        closest_value(
            to_tree(vec![Some(4), Some(2), Some(5), Some(1), Some(3)]),
            3.714286
        )
    ); // 4
    println!("{}", closest_value(to_tree(vec![Some(1)]), 4.428571)); // 4
}
