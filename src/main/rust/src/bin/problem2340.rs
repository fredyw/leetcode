// https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/description/
pub fn minimum_swaps(mut nums: Vec<i32>) -> i32 {
    let mut max = 0;
    let mut max_index = 0;
    for (i, n) in nums.iter().enumerate() {
        if max <= *n {
            max = *n;
            max_index = i;
        }
    }
    let mut answer = 0;
    for i in max_index..nums.len() - 1 {
        nums.swap(i, i + 1);
        answer += 1;
    }
    let mut min = i32::MAX;
    let mut min_index = 0;
    for (i, n) in nums.iter().enumerate() {
        if min > *n {
            min = *n;
            min_index = i;
        }
    }
    answer + min_index as i32
}

fn main() {
    println!("{}", minimum_swaps(vec![3, 4, 5, 5, 3, 1])); // 6
    println!("{}", minimum_swaps(vec![9])); // 0
    println!("{}", minimum_swaps(vec![1, 1])); // 0
    println!("{}", minimum_swaps(vec![1, 1, 1])); // 0
}
