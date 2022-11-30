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
    let vec = to_vec(&head);
    let mut answer: Vec<i32> = vec![];
    for i in (0..vec.len()).rev() {
        if i == vec.len() - 1 {
            answer.push(vec[i]);
        } else {
            let last = answer[answer.len() - 1];
            let max = last.max(vec[i]);
            if max != last || vec[i] == max {
                answer.push(max);
            }
        }
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
    println!(
        "{:?}",
        to_vec(&remove_nodes(to_linked_list(vec![5, 2, 13, 3, 8])))
    ); // [13,8]
    println!(
        "{:?}",
        to_vec(&remove_nodes(to_linked_list(vec![5, 2, 8, 3, 13])))
    ); // [13]
    println!(
        "{:?}",
        to_vec(&remove_nodes(to_linked_list(vec![5, 2, 13, 3, 8, 1, 4])))
    ); // [13,8,4]
    println!(
        "{:?}",
        to_vec(&remove_nodes(to_linked_list(vec![1, 1, 1, 1])))
    ); // [1,1,1,1]
}
