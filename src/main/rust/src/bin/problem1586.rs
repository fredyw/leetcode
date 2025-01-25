use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;

// https://leetcode.com/problems/binary-search-tree-iterator-ii/description/
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

struct BSTIterator {
    index: isize,
    nodes: Vec<i32>,
}

impl BSTIterator {
    fn new(root: Option<Rc<RefCell<TreeNode>>>) -> Self {
        fn inorder(root: Option<Rc<RefCell<TreeNode>>>, inorder_nodes: &mut Vec<i32>) {
            if let Some(node) = root {
                let left = node.as_ref().borrow().left.clone();
                let right = node.as_ref().borrow().right.clone();
                inorder(left, inorder_nodes);
                inorder_nodes.push(node.as_ref().borrow().val);
                inorder(right, inorder_nodes);
            }
        }

        let mut nodes = vec![];
        inorder(root, &mut nodes);
        Self { index: -1, nodes }
    }

    fn has_next(&self) -> bool {
        self.index != self.nodes.len() as isize - 1
    }

    fn next(&mut self) -> i32 {
        let val = self.nodes[(self.index + 1) as usize];
        self.index += 1;
        val
    }

    fn has_prev(&self) -> bool {
        self.index != -1
    }

    fn prev(&mut self) -> i32 {
        let val = self.nodes[(self.index - 1) as usize];
        self.index -= 1;
        val
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
    // let mut iter = BSTIterator::new(to_tree(vec![
    //     Some(7),
    //     Some(3),
    //     Some(15),
    //     None,
    //     None,
    //     Some(9),
    //     Some(20),
    // ]));
    // println!("{}", iter.next()); // 3
    // println!("{}", iter.next()); // 7
    // println!("{}", iter.prev()); // 3
    // println!("{}", iter.next()); // 7
    // println!("{}", iter.has_next()); // true
    // println!("{}", iter.next()); // 9
    // println!("{}", iter.next()); // 15
    // println!("{}", iter.next()); // 20
    // println!("{}", iter.has_next()); // false
    // println!("{}", iter.has_prev()); // true
    // println!("{}", iter.prev()); // 15
    // println!("{}", iter.prev()); // 9

    let mut iter = BSTIterator::new(to_tree(vec![Some(1)]));
    println!("{}", iter.has_prev()); // false
    println!("{}", iter.has_next()); // true
    println!("{}", iter.next()); // true
    println!("{}", iter.has_prev()); // false
    println!("{}", iter.has_next()); // false
}
