// https://leetcode.com/problems/valid-elements-in-an-array/description/
pub fn find_valid_elements(nums: Vec<i32>) -> Vec<i32> {
    let mut max_left = vec![0; nums.len()];
    for (i, &n) in nums.iter().enumerate() {
        if i == 0 {
            max_left[i] = n;
        } else {
            max_left[i] = max_left[i - 1].max(n);
        }
    }
    let mut max_right = vec![0; nums.len()];
    for (i, &n) in nums.iter().enumerate().rev() {
        if i == nums.len() - 1 {
            max_right[i] = n;
        } else {
            max_right[i] = max_right[i + 1].max(n);
        }
    }
    let mut answer = vec![];
    answer.push(nums[0]);
    for i in 1..nums.len() - 1 {
        if nums[i] > max_left[i - 1] || nums[i] > max_right[i + 1] {
            answer.push(nums[i]);
        }
    }
    if nums.len() > 1 {
        answer.push(nums[nums.len() - 1]);
    }
    answer
}

fn main() {
    println!("{:?}", find_valid_elements(vec![1, 2, 4, 2, 3, 2])); // [1,2,4,3,2]
    println!("{:?}", find_valid_elements(vec![5, 5, 5, 5])); // [5,5]
    println!("{:?}", find_valid_elements(vec![1])); // [1]
}
