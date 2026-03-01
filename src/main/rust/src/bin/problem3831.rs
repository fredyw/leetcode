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

// https://leetcode.com/problems/median-of-a-binary-search-tree-level/
pub fn level_median(root: Option<Rc<RefCell<TreeNode>>>, level: i32) -> i32 {
    let mut queue: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
    queue.push_back(root);
    let mut cur_level = 0;
    while !queue.is_empty() {
        if cur_level == level {
            break;
        }
        let size = queue.len();
        for _ in 0..size {
            if let Some(node) = queue.pop_front() {
                if let Some(node) = node.as_ref() {
                    if node.borrow().left.is_some() {
                        queue.push_back(node.borrow().left.clone());
                    }
                    if node.borrow().right.is_some() {
                        queue.push_back(node.borrow().right.clone());
                    }
                }
            }
        }
        cur_level += 1;
    }
    if queue.is_empty() {
        -1
    } else {
        let mut nums = queue
            .into_iter()
            .filter_map(|n| n.map(|n| n.borrow().val).or(None))
            .collect::<Vec<i32>>();
        nums.sort_unstable();
        let mid = nums.len() / 2;
        if nums.len() % 2 == 0 {
            nums[mid - 1].max(nums[mid])
        } else {
            nums[mid]
        }
    }
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
        level_median(to_tree(vec![Some(4), None, Some(5), None, Some(7)]), 2)
    ); // 7
    println!(
        "{}",
        level_median(to_tree(vec![Some(6), Some(3), Some(8)]), 1)
    ); // 8
    println!("{}", level_median(to_tree(vec![Some(2), Some(1)]), 2)); // -1
    println!("{}", level_median(to_tree(vec![Some(2), Some(1)]), 0)); // 2
}
