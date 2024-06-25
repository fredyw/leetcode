use std::collections::HashMap;

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

// https://leetcode.com/problems/linked-list-frequency/description/
pub fn frequencies_of_elements(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut node = head;
    let mut map: HashMap<i32, i32> = HashMap::new();
    while let Some(n) = node {
        *map.entry(n.val).or_insert(0) += 1;
        node = n.next;
    }
    let mut answer: Option<Box<ListNode>> = None;
    let mut current = &mut answer;
    for (_, count) in map.into_iter() {
        match current {
            None => {
                answer = Some(Box::new(ListNode::new(count)));
                current = &mut answer;
            }
            Some(n) => {
                n.next = Some(Box::new(ListNode::new(count)));
                current = &mut n.next;
            }
        }
    }
    answer
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

fn main() {
    println!(
        "{:?}",
        to_vec(frequencies_of_elements(to_linked_list(vec![
            1, 1, 2, 1, 2, 3
        ])))
    ); // [3,2,1]
    println!(
        "{:?}",
        to_vec(frequencies_of_elements(to_linked_list(vec![1, 1, 2, 2, 2])))
    ); // [2,3]
    println!(
        "{:?}",
        to_vec(frequencies_of_elements(to_linked_list(vec![
            6, 5, 4, 3, 2, 1
        ])))
    ); // [1,1,1,1,1,1]
}
