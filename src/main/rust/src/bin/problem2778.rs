// https://leetcode.com/problems/sum-of-squares-of-special-elements/
pub fn sum_of_squares(nums: Vec<i32>) -> i32 {
    nums.iter()
        .enumerate()
        .filter(|(i, _)| nums.len() % (*i + 1) == 0)
        .map(|(_, n)| n * n)
        .sum()
}

fn main() {
    println!("{}", sum_of_squares(vec![1, 2, 3, 4])); // 21
    println!("{}", sum_of_squares(vec![2, 7, 1, 19, 18, 3])); // 63
}
