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

// https://leetcode.com/problems/binary-tree-upside-down/description/
pub fn upside_down_binary_tree(
    root: Option<Rc<RefCell<TreeNode>>>,
) -> Option<Rc<RefCell<TreeNode>>> {
    struct Answer {
        root: Option<Rc<RefCell<TreeNode>>>,
        current: Option<Rc<RefCell<TreeNode>>>,
    }

    fn upside_down_binary_tree(
        root: Option<Rc<RefCell<TreeNode>>>,
        answer: &mut Answer,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        if root.is_none() {
            return None;
        }
        if root.as_ref().unwrap().borrow().left.is_none()
            && root.as_ref().unwrap().borrow().right.is_none()
        {
            return Some(Rc::new(RefCell::new(TreeNode::new(
                root.as_ref().unwrap().borrow().val,
            ))));
        }
        let new_root =
            upside_down_binary_tree(root.as_ref().unwrap().borrow().left.clone(), answer);
        new_root.as_ref().unwrap().borrow_mut().left =
            upside_down_binary_tree(root.as_ref().unwrap().borrow().right.clone(), answer);
        new_root.as_ref().unwrap().borrow_mut().right = Some(Rc::new(RefCell::new(TreeNode::new(
            root.as_ref().unwrap().borrow().val,
        ))));
        if answer.root.is_none() {
            answer.root = new_root.clone();
        }
        answer.current = new_root.as_ref().unwrap().borrow().right.clone();
        answer.current.clone()
    }

    let mut answer = Answer {
        root: None,
        current: None,
    };
    let new_root = upside_down_binary_tree(root, &mut answer);
    if answer.root.is_none() {
        answer.root = new_root;
    }
    answer.root
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
    println!(
        "{:?}",
        to_vec(&upside_down_binary_tree(to_tree(vec![
            Some(1),
            Some(2),
            Some(3),
            Some(4),
            Some(5)
        ])))
    ); // [4,5,2,null,null,3,1]
    println!("{:?}", to_vec(&upside_down_binary_tree(to_tree(vec![])))); // []
    println!(
        "{:?}",
        to_vec(&upside_down_binary_tree(to_tree(vec![Some(1)])))
    ); // [1]
    println!(
        "{:?}",
        to_vec(&upside_down_binary_tree(to_tree(vec![
            Some(1),
            Some(2),
            Some(3),
        ])))
    ); // [2,3,1]
    println!(
        "{:?}",
        to_vec(&upside_down_binary_tree(to_tree(vec![
            Some(1),
            Some(2),
            None,
            Some(3),
            None,
            Some(4),
        ])))
    ); // [4,null,3,null,2,null,1]
    println!(
        "{:?}",
        to_vec(&upside_down_binary_tree(to_tree(vec![
            Some(1),
            Some(2),
            Some(3),
            Some(4),
            Some(5),
            None,
            None,
            Some(6),
            Some(7),
            None,
            None,
            Some(8),
        ])))
    ); // [8,null,6,7,4,null,null,5,2,null,null,3,1]
}
