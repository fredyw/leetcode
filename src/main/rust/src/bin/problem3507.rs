// https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/
pub fn minimum_pair_removal(mut nums: Vec<i32>) -> i32 {
    fn is_sorted(nums: &Vec<i32>) -> bool {
        for i in 0..nums.len() - 1 {
            if nums[i] > nums[i + 1] {
                return false;
            }
        }
        true
    }

    let mut answer = 0;
    while !is_sorted(&nums) {
        let mut sum = i32::MAX;
        let mut index = 0;
        for i in 0..nums.len() - 1 {
            if nums[i] + nums[i + 1] < sum {
                sum = nums[i] + nums[i + 1];
                index = i;
            }
        }
        let mut tmp = vec![];
        let mut i = 0;
        while i < nums.len() {
            if i == index {
                tmp.push(nums[i] + nums[i + 1]);
                i += 2;
            } else {
                tmp.push(nums[i]);
                i += 1;
            }
        }
        nums = tmp;
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_pair_removal(vec![5, 2, 3, 1])); // 2
    println!("{}", minimum_pair_removal(vec![1, 2, 2])); // 0
    println!("{}", minimum_pair_removal(vec![5, 1, 3, 2])); // 2
    println!("{}", minimum_pair_removal(vec![10, 1, 3, 2])); // 3
}
