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

// https://leetcode.com/problems/split-bst/
pub fn split_bst(
    root: Option<Rc<RefCell<TreeNode>>>,
    target: i32,
) -> Vec<Option<Rc<RefCell<TreeNode>>>> {
    fn f(root: Option<Rc<RefCell<TreeNode>>>, target: i32) -> Vec<Option<Rc<RefCell<TreeNode>>>> {
        if root.is_none() {
            return vec![None, None];
        }
        if root.as_ref().unwrap().borrow().val > target {
            let split = f(root.as_ref().unwrap().borrow().left.clone(), target);
            root.as_ref().unwrap().borrow_mut().left = split[1].clone();
            vec![split[0].clone(), root]
        } else {
            let split = f(root.as_ref().unwrap().borrow().right.clone(), target);
            root.as_ref().unwrap().borrow_mut().right = split[0].clone();
            vec![root, split[1].clone()]
        }
    }

    f(root, target)
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
            deque.push_back(left);
            deque.push_back(right);
        } else {
            v.push(None);
        }
    }
    while let Some(node) = v.last() {
        if node.is_some() {
            break;
        }
        v.pop();
    }
    v
}

fn main() {
    let split = split_bst(
        to_tree(vec![
            Some(4),
            Some(2),
            Some(6),
            Some(1),
            Some(3),
            Some(5),
            Some(7),
        ]),
        2,
    );
    println!("{:?}", vec![to_vec(&split[0]), to_vec(&split[1])]); // [[2,1],[4,3,6,null,null,5,7]]

    let split = split_bst(to_tree(vec![Some(1)]), 1);
    println!("{:?}", vec![to_vec(&split[0]), to_vec(&split[1])]); // [[1],[]]

    let split = split_bst(
        to_tree(vec![
            Some(4),
            Some(2),
            Some(6),
            Some(1),
            Some(3),
            Some(5),
            Some(7),
        ]),
        5,
    );
    println!("{:?}", vec![to_vec(&split[0]), to_vec(&split[1])]); // [[4,2,5,1,3],[6,null,7]]

    let split = split_bst(
        to_tree(vec![
            Some(4),
            Some(2),
            Some(6),
            Some(1),
            Some(3),
            Some(5),
            Some(10),
        ]),
        7,
    );
    println!("{:?}", vec![to_vec(&split[0]), to_vec(&split[1])]); // [[4,2,6,1,3,5],[10]]

    let split = split_bst(
        to_tree(vec![
            Some(20),
            Some(8),
            Some(25),
            Some(2),
            Some(16),
            None,
            None,
            None,
            None,
            Some(13),
        ]),
        14,
    );
    println!("{:?}", vec![to_vec(&split[0]), to_vec(&split[1])]); // [[8,2,13],[20,16,25]]

    let split = split_bst(
        to_tree(vec![
            Some(20),
            Some(8),
            Some(25),
            Some(2),
            Some(16),
            None,
            None,
            None,
            None,
            Some(13),
            Some(18),
        ]),
        17,
    );
    println!("{:?}", vec![to_vec(&split[0]), to_vec(&split[1])]); // [[8,2,16,null,null,13],[20,18,25]]
}
