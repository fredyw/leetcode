use std::cmp::max;

// https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/
pub fn min_increments(n: i32, cost: Vec<i32>) -> i32 {
    fn min_increments(cost: &Vec<i32>, index: usize, answer: &mut i32) -> i32 {
        if index > cost.len() {
            return 0;
        }
        let left = min_increments(cost, index * 2, answer);
        let right = min_increments(cost, index * 2 + 1, answer);
        *answer += (left - right).abs();
        cost[index - 1] + max(left, right)
    }

    let mut answer = 0;
    min_increments(&cost, 1, &mut answer);
    answer
}

fn main() {
    println!("{}", min_increments(7, vec![1, 5, 2, 2, 3, 3, 1])); // 6
    println!("{}", min_increments(3, vec![5, 3, 3])); // 0
}
