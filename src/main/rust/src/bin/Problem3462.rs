use std::collections::BinaryHeap;

// https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/description/
pub fn max_sum(grid: Vec<Vec<i32>>, mut limits: Vec<i32>, mut k: i32) -> i64 {
    let mut heaps: Vec<BinaryHeap<i32>> = vec![BinaryHeap::new(); grid.len()];
    for (i, g) in grid.into_iter().enumerate() {
        for n in g {
            heaps[i].push(n);
        }
    }
    let mut answer: i64 = 0;
    while k > 0 {
        let mut max = 0;
        let mut max_index = 0;
        for (i, heap) in heaps.iter_mut().enumerate() {
            if let Some(n) = heap.peek() {
                if max < *n && limits[i] > 0 {
                    max = *n;
                    max_index = i;
                }
            }
        }
        limits[max_index] -= 1;
        answer += max as i64;
        heaps[max_index].pop();
        k -= 1;
    }
    answer
}

fn main() {
    println!("{}", max_sum(vec![vec![1, 2], vec![3, 4]], vec![1, 2], 2)); // 7
    println!(
        "{}",
        max_sum(vec![vec![5, 3, 7], vec![8, 2, 6]], vec![2, 2], 3)
    ); // 21
    println!(
        "{}",
        max_sum(
            vec![vec![7, 5, 3], vec![8, 6, 2], vec![9, 5, 4], vec![10, 9, 7]],
            vec![2, 1, 3, 2],
            6
        )
    ); // 48
}
