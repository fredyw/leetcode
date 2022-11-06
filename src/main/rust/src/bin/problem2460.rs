// https://leetcode.com/problems/apply-operations-to-an-array/
pub fn apply_operations(mut nums: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![0; nums.len()];
    let mut j = 0;
    for i in 0..nums.len() {
        if i + 1 < nums.len() && nums[i] == nums[i + 1] {
            nums[i] = nums[i] * 2;
            nums[i + 1] = 0;
            if nums[i] > 0 {
                answer[j] = nums[i];
                j += 1;
            }
        } else {
            if nums[i] > 0 {
                answer[j] = nums[i];
                j += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{:?}", apply_operations(vec![1, 2, 2, 1, 1, 0])); // [1,4,2,0,0,0]
    println!("{:?}", apply_operations(vec![0, 1])); // [1,0]
}
