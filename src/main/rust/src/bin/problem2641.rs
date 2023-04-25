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

    let answer = root.clone();
    let mut deque: VecDeque<(Option<Rc<RefCell<TreeNode>>>, i32)> = VecDeque::new();
    deque.push_back((root, 0));
    while !deque.is_empty() {
        let size = deque.len();
        let mut total_sum = 0;
        let mut v = vec![];
        for _ in 0..size {
            let mut sum = 0;
            let (node, new_value) = deque.pop_front().unwrap();
            if let Some(node) = node.clone() {
                node.borrow_mut().val = new_value;
                let left = node.borrow().left.clone();
                if let Some(l) = left.clone() {
                    let val = l.borrow().val;
                    sum += val;
                    total_sum += val;
                }
                let right = node.borrow().right.clone();
                if let Some(r) = right.clone() {
                    let val = r.borrow().val;
                    sum += val;
                    total_sum += val;
                }
            }
            if let Some(node) = node.clone() {
                let left = node.borrow().left.clone();
                if left.is_some() {
                    v.push((left, sum));
                }
                let right = node.borrow().right.clone();
                if right.is_some() {
                    v.push((right, sum));
                }
            }
        }
        for (node, sum) in v.into_iter() {
            deque.push_back((node, total_sum - sum));
        }
    }
    answer
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
                    }
                    i += 1;
                    if i + 1 < nodes.len() {
                        if let Some(right) = nodes[i + 1] {
                            deque.push_back(add_right(&parent, right));
                        }
                    }
                    i += 1;
                }
            }
            root
        } else {
            None
        }
    }

    fn to_vec(root: &Option<Rc<RefCell<TreeNode>>>) -> Vec<Option<i32>> {
        let mut v = vec![];
        let mut deque: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
        deque.push_back(root.clone());
        while !deque.is_empty() {
            let node = deque.pop_front().unwrap();
            if let Some(node) = node {
                v.push(Some(node.borrow().val));
                let left = node.borrow().left.clone();
                let right = node.borrow().right.clone();
                if left.is_none() && right.is_none() {
                    continue;
                }
                deque.push_back(left);
                deque.push_back(right);
            } else {
                v.push(None);
            }
        }
        v
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
