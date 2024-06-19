use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;
use std::sync::mpsc::channel;

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

// https://leetcode.com/problems/construct-binary-tree-from-string/description/
pub fn str2tree(s: String) -> Option<Rc<RefCell<TreeNode>>> {
    fn create_node(value: i32) -> Option<Rc<RefCell<TreeNode>>> {
        Some(Rc::new(RefCell::new(TreeNode::new(value))))
    }

    fn str2tree(chars: &Vec<char>, i: &mut usize) -> Option<Rc<RefCell<TreeNode>>> {
        let mut num: String = String::new();
        while *i < chars.len() && chars[*i] != '(' && chars[*i] != ')' {
            num.push(chars[*i]);
            *i += 1;
        }
        let node = create_node(num.parse::<i32>().unwrap());
        if *i < chars.len() && chars[*i] == '(' {
            *i += 1;
            node.as_ref().unwrap().borrow_mut().left = str2tree(chars, i);
        }
        if *i < chars.len() && chars[*i] == '(' {
            *i += 1;
            node.as_ref().unwrap().borrow_mut().right = str2tree(chars, i);
        }
        *i += 1;
        node
    }

    let chars: Vec<char> = s.chars().collect();
    if chars.len() == 0 {
        None
    } else {
        str2tree(&chars, &mut 0)
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

fn main() {
    println!("{:?}", to_vec(&str2tree("4(2(3)(1))(6(5))".to_string()))); // [4,2,6,3,1,5]
    println!("{:?}", to_vec(&str2tree("4(2(3)(1))(6(5)(7))".to_string()))); // [4,2,6,3,1,5,7]
    println!(
        "{:?}",
        to_vec(&str2tree("-4(2(3)(1))(6(5)(7))".to_string()))
    ); // [-4,2,6,3,1,5,7]
}
