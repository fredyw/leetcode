// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
use std::cell::RefCell;
use std::collections::{HashMap, VecDeque};
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

pub fn minimum_operations(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
    fn swap(v: &mut Vec<i32>, i: usize, j: usize) {
        let tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }

    let mut answer = 0;
    let mut deque: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
    deque.push_back(root.clone());
    while !deque.is_empty() {
        let size = deque.len();
        let mut vec: Vec<i32> = vec![];
        let mut map: HashMap<i32, usize> = HashMap::new();
        for i in 0..size {
            let node = deque.pop_front().unwrap().clone();
            vec.push(node.as_ref().unwrap().as_ref().borrow().val);
            map.insert(node.as_ref().unwrap().as_ref().borrow().val, i);
            if let Some(n) = node {
                let left = n.as_ref().borrow().left.clone();
                if left.is_some() {
                    deque.push_back(left);
                }
                let right = n.as_ref().borrow().right.clone();
                if right.is_some() {
                    deque.push_back(right);
                }
            }
        }
        let mut sorted_vec = vec.clone();
        sorted_vec.sort();
        for i in 0..vec.len() {
            if vec[i] == sorted_vec[i] {
                continue;
            }
            let n = sorted_vec[i];
            let j = *map.get(&n).as_ref().unwrap().clone();
            map.insert(vec[i], j);
            swap(&mut vec, i, j);
            answer += 1;
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
        minimum_operations(to_tree(vec![
            Some(1),
            Some(4),
            Some(3),
            Some(7),
            Some(6),
            Some(8),
            Some(5),
            None,
            None,
            None,
            None,
            Some(9),
            None,
            Some(10)
        ]))
    ); // 3
    println!(
        "{}",
        minimum_operations(to_tree(vec![
            Some(1),
            Some(3),
            Some(2),
            Some(7),
            Some(6),
            Some(5),
            Some(4)
        ]))
    ); // 3
    println!(
        "{}",
        minimum_operations(to_tree(vec![
            Some(1),
            Some(2),
            Some(3),
            Some(4),
            Some(5),
            Some(6)
        ]))
    ); // 0
    println!(
        "{}",
        minimum_operations(to_tree(vec![
            Some(9),
            Some(4),
            Some(5),
            Some(3),
            Some(7),
            Some(8)
        ]))
    ); // 0
    println!(
        "{}",
        minimum_operations(to_tree(vec![
            Some(1),
            Some(2),
            Some(3),
            Some(7),
            Some(6),
            Some(4),
            Some(5)
        ]))
    ); // 3
    println!(
        "{}",
        minimum_operations(to_tree(vec![
            Some(1),
            Some(2),
            Some(3),
            Some(7),
            Some(6),
            Some(5),
            Some(4)
        ]))
    ); // 2
}
