// https://leetcode.com/problems/minimum-deletions-to-make-array-sharp/description/
pub fn min_deletions(nums: Vec<i32>) -> i32 {
    let mut unique_nums: Vec<i32> = Vec::new();
    let mut i = 0;
    while i < nums.len() {
        let mut j = i;
        unique_nums.push(nums[i]);
        while j < nums.len() && nums[i] == nums[j] {
            j += 1;
        }
        i = j;
    }
    nums.len() as i32 - unique_nums.len() as i32
}

fn main() {
    println!("{}", min_deletions(vec![1, 1, 2, 2, 2, 3])); // 3
    println!("{}", min_deletions(vec![4, 4, 9, 4])); // 1
    println!("{}", min_deletions(vec![9, 2])); // 0
}
