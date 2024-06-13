use std::cell::RefCell;
use std::collections::{BTreeMap, VecDeque};
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

// https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
pub fn vertical_order(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
    let mut deque: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
    deque.push_back(root.clone());
    while !deque.is_empty() {
        let current = deque.pop_front().unwrap();
        let left = current.as_ref().unwrap().borrow().left.clone();
        let right = current.as_ref().unwrap().borrow().right.clone();
    }
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
        "{:?}",
        vertical_order(to_tree(vec![
            Some(3),
            Some(9),
            Some(20),
            None,
            None,
            Some(15),
            Some(7),
        ]))
    ); // [[9],[3,15],[20],[7]]
    println!(
        "{:?}",
        vertical_order(to_tree(vec![
            Some(3),
            Some(9),
            Some(8),
            Some(4),
            Some(0),
            Some(1),
            Some(7),
        ]))
    ); // [[4],[9],[3,0,1],[8],[7]]
    println!(
        "{:?}",
        vertical_order(to_tree(vec![
            Some(3),
            Some(9),
            Some(8),
            Some(4),
            Some(0),
            Some(1),
            Some(7),
            None,
            None,
            None,
            Some(2),
            Some(5),
        ]))
    ); // [[4],[9,5],[3,0,1],[8,2],[7]]
}
