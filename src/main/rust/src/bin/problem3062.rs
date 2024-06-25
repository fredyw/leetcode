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
    fn to_vec(node: Option<Box<ListNode>>) -> Vec<i32> {
        let mut node = node;
        let mut v: Vec<i32> = vec![];
        while let Some(n) = node {
            v.push(n.val);
            node = n.next
        }
        v
    }

    let mut odd_win = 0;
    let mut even_win = 0;
    let vec: Vec<i32> = to_vec(head);
    let mut i = 0;
    while i < vec.len() - 1 {
        if vec[i] < vec[i + 1] {
            odd_win += 1;
        } else if vec[i] > vec[i + 1] {
            even_win += 1;
        }
        i += 2;
    }
    if even_win > odd_win {
        "Even".to_string()
    } else if even_win < odd_win {
        "Odd".to_string()
    } else {
        "Tie".to_string()
    }
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
