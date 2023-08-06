// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
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

pub fn insert_greatest_common_divisors(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    fn gcd(a: i32, b: i32) -> i32 {
        if a == b {
            return a;
        }
        if a > b {
            return gcd(a - b, b);
        }
        gcd(a, b - a)
    }
    todo!()
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
    println!(
        "{:?}",
        to_vec(&insert_greatest_common_divisors(to_linked_list(vec![
            18, 6, 10, 3
        ])))
    ); // [18,6,6,2,10,1,3]
    println!(
        "{:?}",
        to_vec(&insert_greatest_common_divisors(to_linked_list(vec![7])))
    ); // [7]
}
