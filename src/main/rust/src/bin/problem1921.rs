use std::cmp::Ordering;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/
pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
    #[derive(Copy, Clone, Eq, PartialEq, Debug)]
    struct Element {
        distance: i32,
        speed: i32,
    }

    fn time(e: &Element) -> i32 {
        if e.distance % e.speed == 0 {
            e.distance / e.speed
        } else {
            (e.distance / e.speed) + 1
        }
    }

    impl Ord for Element {
        fn cmp(&self, other: &Self) -> Ordering {
            time(other).cmp(&time(self))
        }
    }

    impl PartialOrd for Element {
        fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
            Some(self.cmp(&other))
        }
    }

    let mut binary_heap: BinaryHeap<Element> = BinaryHeap::new();
    for i in 0..dist.len() {
        binary_heap.push(Element {
            distance: dist[i],
            speed: speed[i],
        });
    }
    let mut answer = 1;
    binary_heap.pop();
    while let Some(e) = binary_heap.pop() {
        if e.distance - (e.speed * answer) <= 0 {
            break;
        }
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", eliminate_maximum(vec![1, 3, 4], vec![1, 1, 1])); // 3
    println!("{}", eliminate_maximum(vec![1, 1, 2, 3], vec![1, 1, 1, 1])); // 1
    println!("{}", eliminate_maximum(vec![3, 2, 4], vec![5, 3, 2])); // 1
    println!("{}", eliminate_maximum(vec![3, 4, 1], vec![1, 1, 1])); // 3
}
