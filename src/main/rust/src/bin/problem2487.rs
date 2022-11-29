// https://leetcode.com/problems/remove-nodes-from-linked-list/
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

pub fn remove_nodes(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    todo!()
}

fn main() {}
