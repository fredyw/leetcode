// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
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

pub fn double_it(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
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

    fn to_vec(node: &Option<Box<ListNode>>) -> Vec<i32> {
        let mut node = node;
        let mut v: Vec<i32> = vec![];
        while let Some(n) = node {
            v.push(n.val);
            node = &n.next
        }
        v
    }

    let v = to_vec(&head);
    let mut answer: Vec<i32> = vec![];
    let mut carry = false;
    for i in (0..v.len()).rev() {
        let d = v[i] * 2;
        answer.push(if carry { d + 1 } else { d } % 10);
        carry = d >= 10;
    }
    if carry {
        answer.push(1);
    }
    answer.reverse();
    to_linked_list(answer)
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

fn to_vec(node: &Option<Box<ListNode>>) -> Vec<i32> {
    let mut node = node;
    let mut v: Vec<i32> = vec![];
    while let Some(n) = node {
        v.push(n.val);
        node = &n.next
    }
    v
}

fn main() {
    println!("{:?}", to_vec(&double_it(to_linked_list(vec![1, 8, 9])))); // [3,7,8]
    println!("{:?}", to_vec(&double_it(to_linked_list(vec![9, 9, 9])))); // [1,9,9,8]
}
