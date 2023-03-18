// https://leetcode.com/problems/maximize-greatness-of-an-array/
pub fn maximize_greatness(mut nums: Vec<i32>) -> i32 {
    nums.sort();
    let mut answer = 0;
    let mut i = 0;
    let mut j = 0;
    while i < nums.len() {
        while j < nums.len() && nums[j] <= nums[i] {
            j += 1;
        }
        if j == nums.len() {
            break;
        }
        answer += 1;
        i += 1;
        j += 1;
    }
    answer
}

fn main() {
    println!("{}", maximize_greatness(vec![1, 3, 5, 2, 1, 3, 1])); // 4
    println!("{}", maximize_greatness(vec![1, 2, 3, 4])); // 3
    println!("{}", maximize_greatness(vec![1, 1, 1, 1])); // 0
    println!("{}", maximize_greatness(vec![1, 1, 1, 14])); // 1
    println!("{}", maximize_greatness(vec![14])); // 0
    println!(
        "{}",
        maximize_greatness(vec![5, 3, 5, 6, 3, 1, 1, 3, 23, 57, 1293, 12, 34])
    ); // 10
}
