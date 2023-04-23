// https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/
pub fn find_prefix_score(nums: Vec<i32>) -> Vec<i64> {
    let mut answer: Vec<i64> = vec![0; nums.len()];
    let mut max = 0;
    for (i, num) in nums.into_iter().enumerate() {
        max = max.max(num);
        answer[i] += if i == 0 { 0 } else { answer[i - 1] } + num as i64 + max as i64;
    }
    answer
}

fn main() {
    println!("{:?}", find_prefix_score(vec![2, 3, 7, 5, 10])); // [4,10,24,36,56]
    println!("{:?}", find_prefix_score(vec![1, 1, 2, 4, 8, 16])); // [2,4,8,16,32,64]
}
