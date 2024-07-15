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

// https://leetcode.com/problems/inorder-successor-in-bst/
pub fn inorder_successor(
    root: Option<Rc<RefCell<TreeNode>>>,
    p: Option<Rc<RefCell<TreeNode>>>,
) -> Option<Rc<RefCell<TreeNode>>> {
    fn inorder_successor(
        root: Option<Rc<RefCell<TreeNode>>>,
        p_val: i32,
        successor: &mut Option<Rc<RefCell<TreeNode>>>,
    ) {
        if root.is_none() {
            return;
        }
        let val = root.as_ref().unwrap().borrow().val;
        if val > p_val {
            if let Some(s) = successor.as_ref() {
                if s.borrow().val > val {
                    *successor = root.clone();
                }
            } else {
                *successor = root.clone();
            }
        }
        if val > p_val {
            inorder_successor(
                root.as_ref().unwrap().borrow().left.clone(),
                p_val,
                successor,
            );
        } else {
            inorder_successor(
                root.as_ref().unwrap().borrow().right.clone(),
                p_val,
                successor,
            );
        }
    }

    let mut answer = None;
    inorder_successor(root, p.as_ref().unwrap().borrow().val, &mut answer);
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
        "{:?}",
        inorder_successor(to_tree(vec![Some(2), Some(1), Some(3)]), create_node(1))
    ); // 2
    println!(
        "{:?}",
        inorder_successor(
            to_tree(vec![
                Some(5),
                Some(3),
                Some(6),
                Some(2),
                Some(4),
                None,
                None,
                Some(1)
            ]),
            create_node(6)
        )
    ); // None
    println!(
        "{:?}",
        inorder_successor(
            to_tree(vec![
                Some(5),
                Some(3),
                Some(6),
                Some(2),
                Some(4),
                None,
                None,
                Some(1)
            ]),
            create_node(2)
        )
    ); // 3
    println!(
        "{:?}",
        inorder_successor(
            to_tree(vec![
                Some(5),
                Some(3),
                Some(6),
                Some(2),
                Some(4),
                None,
                None,
                Some(1)
            ]),
            create_node(3)
        )
    ); // 4
    println!(
        "{:?}",
        inorder_successor(
            to_tree(vec![
                Some(5),
                Some(3),
                Some(6),
                Some(2),
                Some(4),
                None,
                None,
                Some(1)
            ]),
            create_node(4)
        )
    ); // 5
}
