// https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/description/
pub fn minimum_cost(nums: Vec<i32>) -> i32 {
    let mut sub = vec![];
    for i in 1..nums.len() {
        sub.push(nums[i]);
    }
    sub.sort();
    nums[0] + sub[0] + sub[1]
}

fn main() {
    println!("{}", minimum_cost(vec![1, 2, 3, 12])); // 6
    println!("{}", minimum_cost(vec![5, 4, 3])); // 12
    println!("{}", minimum_cost(vec![10, 3, 1, 1])); // 12
}
