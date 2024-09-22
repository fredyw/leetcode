use std::collections::HashSet;

#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

// https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
pub fn modified_list(nums: Vec<i32>, head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    fn to_linked_list(v: Vec<i32>) -> Option<Box<ListNode>> {
        let mut head: Option<Box<ListNode>> = None;
        let mut current = &mut head;
        for i in v.iter() {
            match current {
                Some(a) => {
                    a.next = Some(Box::new(ListNode::new(*i)));
                    current = &mut a.next;
                }
                None => {
                    head = Some(Box::new(ListNode::new(*i)));
                    current = &mut head;
                }
            }
        }
        head
    }

    let nums: HashSet<i32> = nums.into_iter().collect();
    let mut node = head;
    let mut v: Vec<i32> = vec![];
    while let Some(n) = node {
        if !nums.contains(&n.val) {
            v.push(n.val);
        }
        node = n.next
    }
    to_linked_list(v)
}

fn to_linked_list(v: Vec<i32>) -> Option<Box<ListNode>> {
    let mut head: Option<Box<ListNode>> = None;
    let mut current = &mut head;
    for i in v.iter() {
        match current {
            Some(a) => {
                a.next = Some(Box::new(ListNode::new(*i)));
                current = &mut a.next;
            }
            None => {
                head = Some(Box::new(ListNode::new(*i)));
                current = &mut head;
            }
        }
    }
    head
}

fn to_vec(node: Option<Box<ListNode>>) -> Vec<i32> {
    let mut node = node;
    let mut v: Vec<i32> = vec![];
    while let Some(n) = node {
        v.push(n.val);
        node = n.next
    }
    v
}

fn main() {
    println!(
        "{:?}",
        to_vec(modified_list(
            vec![1, 2, 3],
            to_linked_list(vec![1, 2, 3, 4, 5])
        ))
    ); // [4,5]
    println!(
        "{:?}",
        to_vec(modified_list(
            vec![1],
            to_linked_list(vec![1, 2, 1, 2, 1, 2])
        ))
    ); // [2,2,2]
    println!(
        "{:?}",
        to_vec(modified_list(vec![5], to_linked_list(vec![1, 2, 3, 4])))
    ); // [1,2,3,4]
}
