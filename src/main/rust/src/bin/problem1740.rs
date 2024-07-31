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

// https://leetcode.com/problems/find-distance-in-a-binary-tree/description/
pub fn find_distance(root: Option<Rc<RefCell<TreeNode>>>, p: i32, q: i32) -> i32 {
    fn build_map(
        root: &Option<Rc<RefCell<TreeNode>>>,
        p: i32,
        map: &mut HashMap<i32, i32>,
    ) -> Option<i32> {
        if root.is_none() {
            return None;
        }
        let val = root.as_ref().unwrap().borrow().val;
        if val == p {
            map.insert(val, 0);
            return Some(0);
        }
        let left = build_map(&root.as_ref().unwrap().borrow().left, p, map);
        let right = build_map(&root.as_ref().unwrap().borrow().right, p, map);
        if left.is_none() && right.is_none() {
            None
        } else if left.is_some() {
            let d = left.unwrap() + 1;
            map.insert(val, d);
            Some(d)
        } else {
            let d = right.unwrap() + 1;
            map.insert(val, d);
            Some(d)
        }
    }

    fn calculate_distance(
        root: &Option<Rc<RefCell<TreeNode>>>,
        q: i32,
        map: &HashMap<i32, i32>,
        distance: &mut Option<i32>,
    ) -> Option<i32> {
        if root.is_none() {
            return None;
        }
        let val = root.as_ref().unwrap().borrow().val;
        if val == q {
            if distance.is_none() {
                if let Some(d) = map.get(&val) {
                    *distance = Some(*d);
                }
            }
            return Some(0);
        }
        let left = calculate_distance(&root.as_ref().unwrap().borrow().left, q, map, distance);
        let right = calculate_distance(&root.as_ref().unwrap().borrow().right, q, map, distance);
        if left.is_none() && right.is_none() {
            None
        } else if left.is_some() {
            if distance.is_none() {
                if let Some(d) = map.get(&val) {
                    *distance = Some(d + left.unwrap() + 1);
                }
            }
            Some(left.unwrap() + 1)
        } else {
            if distance.is_none() {
                if let Some(d) = map.get(&val) {
                    *distance = Some(d + right.unwrap() + 1);
                }
            }
            Some(right.unwrap() + 1)
        }
    }

    let mut map: HashMap<i32, i32> = HashMap::new();
    build_map(&root, p, &mut map);
    let mut answer: Option<i32> = None;
    calculate_distance(&root, q, &map, &mut answer);
    answer.unwrap_or(0)
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
        "{}",
        find_distance(
            to_tree(vec![
                Some(3),
                Some(5),
                Some(1),
                Some(6),
                Some(2),
                Some(0),
                Some(8),
                None,
                None,
                Some(7),
                Some(4)
            ]),
            5,
            0
        )
    ); // 3
    println!(
        "{}",
        find_distance(
            to_tree(vec![
                Some(3),
                Some(5),
                Some(1),
                Some(6),
                Some(2),
                Some(0),
                Some(8),
                None,
                None,
                Some(7),
                Some(4)
            ]),
            5,
            7
        )
    ); // 2
    println!(
        "{}",
        find_distance(
            to_tree(vec![
                Some(3),
                Some(5),
                Some(1),
                Some(6),
                Some(2),
                Some(0),
                Some(8),
                None,
                None,
                Some(7),
                Some(4)
            ]),
            5,
            5
        )
    ); // 0
    println!(
        "{}",
        find_distance(to_tree(vec![Some(11), Some(18), None, Some(3),]), 3, 11)
    ); // 2
}
