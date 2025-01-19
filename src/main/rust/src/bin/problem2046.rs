// https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values/description/
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

pub fn sort_linked_list(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    fn to_vec(node: &Option<Box<ListNode>>) -> Vec<i32> {
        let mut node = node;
        let mut v: Vec<i32> = vec![];
        while let Some(n) = node {
            v.push(n.val);
            node = &n.next
        }
        v
    }

    fn to_linked_list(v: &Vec<i32>) -> Option<Box<ListNode>> {
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

    let mut v = to_vec(&head);
    v.sort();
    to_linked_list(&v)
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
        to_vec(sort_linked_list(to_linked_list(vec![0, 2, -5, 5, 10, -10])))
    ); // [-10,-5,0,2,5,10]
    println!(
        "{:?}",
        to_vec(sort_linked_list(to_linked_list(vec![0, 1, 2])))
    ); // [0,1,2]
    println!("{:?}", to_vec(sort_linked_list(to_linked_list(vec![1])))); // [1]
}
