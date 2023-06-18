use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;

// https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/
pub fn min_increments(n: i32, cost: Vec<i32>) -> i32 {
    #[derive(Debug, PartialEq, Eq)]
    struct TreeNode {
        pub value: i32,
        pub left: Option<Rc<RefCell<TreeNode>>>,
        pub right: Option<Rc<RefCell<TreeNode>>>,
    }

    impl TreeNode {
        fn new(value: i32) -> Option<Rc<RefCell<TreeNode>>> {
            Some(Rc::new(RefCell::new(TreeNode {
                value,
                left: None,
                right: None,
            })))
        }
    }

    fn add_left(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        parent.as_ref().unwrap().as_ref().borrow_mut().left = TreeNode::new(value);
        parent.as_ref().unwrap().as_ref().borrow().left.clone()
    }

    fn add_right(
        parent: &Option<Rc<RefCell<TreeNode>>>,
        value: i32,
    ) -> Option<Rc<RefCell<TreeNode>>> {
        parent.as_ref().unwrap().as_ref().borrow_mut().right = TreeNode::new(value);
        parent.as_ref().unwrap().as_ref().borrow().right.clone()
    }

    fn to_tree(cost: &Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        let mut deque: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();
        let root = TreeNode::new(cost[0]);
        deque.push_back(root.clone());
        let mut i = 1;
        while i < cost.len() {
            let parent = deque.pop_front().unwrap();
            let left = add_left(&parent, cost[i]);
            let right = add_right(&parent, cost[i + 1]);
            deque.push_back(left.clone());
            deque.push_back(right.clone());
            i += 2;
        }
        root
    }
    0
}

fn main() {
    println!("{}", min_increments(7, vec![1, 5, 2, 2, 3, 3, 1])); // 6
    println!("{}", min_increments(3, vec![5, 3, 3])); // 0
}
