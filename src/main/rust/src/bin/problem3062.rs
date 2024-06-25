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

// https://leetcode.com/problems/winner-of-the-linked-list-game/description/
pub fn game_result(head: Option<Box<ListNode>>) -> String {
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

fn main() {
    println!("{}", game_result(to_linked_list(vec![2, 1]))); // "Even"
    println!("{}", game_result(to_linked_list(vec![2, 5, 4, 7, 20, 5]))); // "Odd"
    println!("{}", game_result(to_linked_list(vec![4, 5, 2, 1]))); // "Tie"
}
