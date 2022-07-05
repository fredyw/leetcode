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
    enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT,
    }
    let mut min_row = 0;
    let mut min_col = 0;
    let mut max_row = m;
    let mut max_col = n;
    let mut answer = vec![vec![-1; max_col as usize]; max_row as usize];
    let mut row = 0;
    let mut col = 0;
    let mut direction = Direction::RIGHT;
    let mut current = &head;
    loop {
        match current {
            Some(a) => {
                answer[row as usize][col as usize] = a.val;
                match direction {
                    Direction::RIGHT => {
                        if col + 1 < max_col {
                            col += 1;
                        } else {
                            direction = Direction::DOWN;
                            row += 1;
                        }
                    }
                    Direction::DOWN => {
                        if row + 1 < max_row {
                            row += 1;
                        } else {
                            direction = Direction::LEFT;
                            col -= 1;
                        }
                    }
                    Direction::LEFT => {
                        if col - 1 >= min_col {
                            col -= 1;
                        } else {
                            direction = Direction::UP;
                            row -= 1;
                        }
                    }
                    Direction::UP => {
                        if row - 1 > min_row {
                            row -= 1;
                        } else {
                            direction = Direction::RIGHT;
                            col += 1;
                            min_col += 1;
                            min_row += 1;
                            max_row -= 1;
                            max_col -= 1;
                        }
                    }
                }
                current = &a.next;
            }
            None => break,
        }
    }
    answer
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
