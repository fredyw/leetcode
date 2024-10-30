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

// https://leetcode.com/problems/plus-one-linked-list/
pub fn plus_one(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
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
    println!("{:?}", to_vec(&plus_one(to_linked_list(vec!(1, 2, 3))))); // [1,2,4]
    println!("{:?}", to_vec(&plus_one(to_linked_list(vec!(0))))); // [1]
    println!("{:?}", to_vec(&plus_one(to_linked_list(vec!(9))))); // [1,0]
}
