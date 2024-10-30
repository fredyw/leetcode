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

fn main() {}
