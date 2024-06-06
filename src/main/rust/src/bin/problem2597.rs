// https://leetcode.com/problems/the-number-of-beautiful-subsets/description/
pub fn beautiful_subsets(mut nums: Vec<i32>, k: i32) -> i32 {
    fn beautiful_subsets(nums: &Vec<i32>, k: i32, i: usize) -> i32 {
        println!("[{}]: {}", i, nums[i]);
        let mut count = 0;
        for j in i + 1..nums.len() {
            println!("-- trying {} with {}", nums[i], nums[j]);
            if nums[j] - nums[i] == k {
                println!("-- nope");
                count += beautiful_subsets(nums, k, j);
            } else {
                println!("-- ok");
                count += beautiful_subsets(nums, k, j) + 1;
            }
        }
        count
    }

    nums.sort();
    println!("{:?}", nums);
    beautiful_subsets(&nums, k, 0) + nums.len() as i32
}

fn main() {
    // println!("{}", beautiful_subsets(vec![2, 4, 6], 2)); // 4
    // println!("{}", beautiful_subsets(vec![1], 1)); // 1
    // println!("{}", beautiful_subsets(vec![2, 4, 6, 9], 2)); // 9
    // println!("{}", beautiful_subsets(vec![2, 4, 6, 8], 2)); // 7
    println!("{}", beautiful_subsets(vec![10, 4, 5, 7, 2, 1], 3)); // 23
}
