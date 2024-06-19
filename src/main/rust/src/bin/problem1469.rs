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

// https://leetcode.com/problems/find-all-the-lonely-nodes/
pub fn get_lonely_nodes(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
    fn get_lonely_nodes(
        root: &Option<Rc<RefCell<TreeNode>>>,
        lonely: bool,
        lonely_nodes: &mut Vec<i32>,
    ) {
        if root.is_none() {
            return;
        }
        let value = root.as_ref().unwrap().borrow().val;
        if lonely {
            lonely_nodes.push(value);
        }
        let left = root.as_ref().unwrap().borrow().left.clone();
        let right = root.as_ref().unwrap().borrow().right.clone();
        let lonely = (left.is_some() && right.is_none()) || (left.is_none() && right.is_some());
        get_lonely_nodes(&left, lonely, lonely_nodes);
        get_lonely_nodes(&right, lonely, lonely_nodes);
    }

    let mut answer = vec![];
    get_lonely_nodes(&root, false, &mut answer);
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
        "{:?}",
        get_lonely_nodes(to_tree(vec![Some(1), Some(2), Some(3), None, Some(4)]))
    ); // [4]
    println!(
        "{:?}",
        get_lonely_nodes(to_tree(vec![
            Some(7),
            Some(1),
            Some(4),
            Some(6),
            None,
            Some(5),
            Some(3),
            None,
            None,
            None,
            None,
            None,
            Some(2)
        ]))
    ); // [6,2]
    println!(
        "{:?}",
        get_lonely_nodes(to_tree(vec![
            Some(11),
            Some(99),
            Some(88),
            Some(77),
            None,
            None,
            Some(66),
            Some(55),
            None,
            None,
            Some(44),
            Some(33),
            None,
            None,
            Some(22),
        ]))
    ); // [77,55,33,66,44,22]
    println!("{:?}", get_lonely_nodes(to_tree(vec![]))); // []
}
