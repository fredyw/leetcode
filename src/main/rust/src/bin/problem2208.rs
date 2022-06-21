use std::cmp::Ordering;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
pub fn halve_array(nums: Vec<i32>) -> i32 {
    #[derive(PartialEq, PartialOrd)]
    struct Wrapper(f64);
    impl Eq for Wrapper {}
    impl Ord for Wrapper {
        fn cmp(&self, other: &Self) -> Ordering {
            self.partial_cmp(&other).unwrap()
        }
    }
    let mut answer = 0;
    let mut heap: BinaryHeap<Wrapper> = BinaryHeap::new();
    let mut total_sum: f64 = 0.0;
    for n in nums {
        total_sum += n as f64;
        heap.push(Wrapper(n as f64));
    }
    let mut s = 0.0;
    while s < total_sum / 2.0 && !heap.is_empty() {
        let half = heap.pop().unwrap().0 / 2.0;
        s += half;
        heap.push(Wrapper(half));
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", halve_array(vec![5, 19, 8, 1])); // 3
    println!("{}", halve_array(vec![3, 8, 20])); // 3
}
