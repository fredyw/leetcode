// https://leetcode.com/problems/cousins-in-binary-tree-ii/
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

pub fn replace_value_in_tree(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
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
        parent.as_ref().unwrap().as_ref().borrow_mut().left = create_node(value);
        parent.as_ref().unwrap().as_ref().borrow().left.clone()
    }

    fn add_right(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        parent.as_ref().unwrap().as_ref().borrow_mut().right = create_node(value);
        parent.as_ref().unwrap().as_ref().borrow().right.clone()
    }

    fn to_tree(nodes: Vec<Option<i32>>) -> Option<Rc<RefCell<TreeNode>>> {
        let mut deque: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
        let mut i = 0;
        if let Some(val) = nodes[i] {
            let root = create_node(val);
            deque.push_back(root.clone());
            while !deque.is_empty() {
                let size = deque.len();
                for _ in 0..size {
                    let parent = deque.pop_front().unwrap();
                    if i + 1 < nodes.len() {
                        if let Some(left) = nodes[i + 1] {
                            deque.push_back(add_left(&parent, left));
                        }
                        i += 1;
                    }
                    if i + 2 < nodes.len() {
                        if let Some(right) = nodes[i + 1] {
                            deque.push_back(add_right(&parent, right));
                        }
                        i += 1;
                    }
                }
            }
            root
        } else {
            None
        }
    }

    fn to_vec(root: &Option<Rc<RefCell<TreeNode>>>) -> Vec<Option<i32>> {
        vec![]
        // todo!()
    }

    let root = to_tree(vec![
        Some(5),
        Some(4),
        Some(9),
        Some(1),
        Some(10),
        None,
        Some(7),
    ]);
    println!("{:?}", to_vec(&replace_value_in_tree(root))); // [0,0,0,7,7,null,11]
    let root = to_tree(vec![Some(3), Some(1), Some(2)]);
    println!("{:?}", to_vec(&replace_value_in_tree(root))); // [0,0,0]
}
