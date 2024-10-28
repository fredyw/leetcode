use std::collections::BinaryHeap;

// https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/
pub fn max_kelements(nums: Vec<i32>, k: i32) -> i64 {
    let mut heap: BinaryHeap<i32> = BinaryHeap::new();
    for num in nums {
        heap.push(num);
    }
    let mut answer = 0;
    let mut n = k;
    while n > 0 {
        let e = heap.pop().unwrap();
        answer += e as i64;
        heap.push(if e % 3 == 0 { e / 3 } else { (e / 3) + 1 });
        n -= 1;
    }
    answer
}

fn main() {
    println!("{}", max_kelements(vec![10, 10, 10, 10, 10], 5)); // 50
    println!("{}", max_kelements(vec![1, 10, 3, 3, 3], 3)); // 17
}
