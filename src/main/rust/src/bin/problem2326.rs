// https://leetcode.com/problems/spiral-matrix-iv/
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

pub fn spiral_matrix(m: i32, n: i32, head: Option<Box<ListNode>>) -> Vec<Vec<i32>> {
    todo!()
}

fn build_linked_list(v: Vec<i32>) -> Option<Box<ListNode>> {
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
    println!(
        "{:?}",
        spiral_matrix(
            3,
            5,
            build_linked_list(vec![3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0])
        )
    ); // [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
    println!(
        "{:?}",
        spiral_matrix(1, 4, build_linked_list(vec![0, 1, 2]))
    ); // [[0,1,2,-1]]
}
