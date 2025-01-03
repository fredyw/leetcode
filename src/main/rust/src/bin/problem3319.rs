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

// https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree/description/
pub fn kth_largest_perfect_subtree(root: Option<Rc<RefCell<TreeNode>>>, k: i32) -> i32 {
    fn kth_largest_perfect_subtree(
        root: Option<Rc<RefCell<TreeNode>>>,
        perfect_subtrees: &mut Vec<i32>,
    ) -> (bool, i32) {
        if let Some(node) = root {
            let left = node.as_ref().borrow().left.clone();
            let right = node.as_ref().borrow().right.clone();
            if left.is_none() && right.is_none() {
                perfect_subtrees.push(1);
                (true, 1)
            } else {
                let (left_perfect, left_count) =
                    kth_largest_perfect_subtree(left, perfect_subtrees);
                let (right_perfect, right_count) =
                    kth_largest_perfect_subtree(right, perfect_subtrees);
                if left_perfect && right_perfect && left_count == right_count {
                    perfect_subtrees.push(left_count + right_count + 1);
                    (true, left_count + right_count + 1)
                } else {
                    (false, -1)
                }
            }
        } else {
            (false, -1)
        }
    }

    let mut perfect_subtrees: Vec<i32> = vec![];
    kth_largest_perfect_subtree(root, &mut perfect_subtrees);
    perfect_subtrees.sort_by(|a, b| b.cmp(&a));
    *perfect_subtrees.get(k as usize - 1).unwrap_or(&-1)
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
        kth_largest_perfect_subtree(
            to_tree(vec![
                Some(5),
                Some(3),
                Some(6),
                Some(5),
                Some(2),
                Some(5),
                Some(7),
                Some(1),
                Some(8),
                None,
                None,
                Some(6),
                Some(8)
            ]),
            2
        )
    ); // 3
    println!(
        "{}",
        kth_largest_perfect_subtree(
            to_tree(vec![
                Some(1),
                Some(2),
                Some(3),
                Some(4),
                Some(5),
                Some(6),
                Some(7)
            ]),
            1
        )
    ); // 7
    println!(
        "{}",
        kth_largest_perfect_subtree(to_tree(vec![Some(1), Some(2), Some(3), None, Some(4)]), 3)
    ); // -1
}
