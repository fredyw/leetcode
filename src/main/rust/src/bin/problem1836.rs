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

// https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/description/
pub fn delete_duplicates_unsorted(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut node = &head;
    while let Some(n) = node {
        *map.entry(n.val).or_insert(0) += 1;
        node = &n.next;
    }
    let mut v: Vec<i32> = vec![];
    let mut node = &head;
    while let Some(n) = node {
        if *map.get(&n.val).unwrap() == 1 {
            v.push(n.val);
        }
        node = &n.next;
    }
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
    println!("{:?}", to_linked_list(vec![1, 2, 3, 2])); // [1,3]
    println!("{:?}", to_linked_list(vec![2, 1, 1, 2])); // []
    println!("{:?}", to_linked_list(vec![3, 2, 2, 1, 3, 2, 4])); // [1,4]
}
