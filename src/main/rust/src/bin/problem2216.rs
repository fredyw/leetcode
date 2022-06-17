// https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
pub fn min_deletion(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut count = 0;
    let mut even = true;
    let mut i = 0;
    while i < nums.len() {
        if even && i + 1 < nums.len() && nums[i] == nums[i + 1] {
            answer += 1;
        } else {
            even = !even;
            count += 1;
        }
        i += 1;
    }
    if count % 2 == 0 {
        answer
    } else {
        answer + 1
    }
}

fn main() {
    println!("{}", min_deletion(vec![1, 1, 2, 3, 5])); // 1
    println!("{}", min_deletion(vec![1, 1, 2, 2, 3, 3])); // 2
    println!("{}", min_deletion(vec![1, 1, 2, 2, 3])); // 1
    println!("{}", min_deletion(vec![1, 1, 1, 1, 1])); // 5
}
