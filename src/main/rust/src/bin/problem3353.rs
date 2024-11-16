// https://leetcode.com/problems/minimum-total-operations/description/
pub fn min_operations(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut i = nums.len() as isize - 1;
    while i >= 0 {
        let n = nums[i as usize];
        while i >= 0 && nums[i as usize] == n {
            i -= 1;
        }
        answer += 1;
    }
    answer - 1
}

fn main() {
    println!("{}", min_operations(vec![1, 4, 2])); // 2
    println!("{}", min_operations(vec![10, 10, 10])); // 0
    println!("{}", min_operations(vec![1, 2, 3])); // 2
    println!("{}", min_operations(vec![1, 4, 2, 4, 2])); // 4
    println!(
        "{}",
        min_operations(vec![2, 2, 2, 1, 1, 1, 2, 2, 2, 3, 3, 3])
    ); // 3
}
