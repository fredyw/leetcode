// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
pub fn valid_partition(nums: Vec<i32>) -> bool {
    fn valid_partition(nums: &Vec<i32>, i: usize, memo: &mut Vec<Option<bool>>) -> bool {
        if i == nums.len() {
            return true;
        }
        if let Some(m) = memo[i] {
            return m;
        }
        let mut found = false;
        if i + 1 < nums.len() {
            if nums[i] == nums[i + 1] {
                found |= valid_partition(nums, i + 2, memo);
            }
        }
        if i + 2 < nums.len() {
            if nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2] {
                found |= valid_partition(nums, i + 3, memo);
            } else if nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2] {
                found |= valid_partition(nums, i + 3, memo);
            }
        }
        memo[i] = Some(found);
        found
    }

    let mut memo = vec![None; nums.len()];
    valid_partition(&nums, 0, &mut memo)
}

fn main() {
    println!("{}", valid_partition(vec![4, 4, 4, 5, 6])); // true
    println!("{}", valid_partition(vec![1, 1, 1, 2])); // false
    println!("{}", valid_partition(vec![1, 1, 1, 1])); // true
    println!("{}", valid_partition(vec![1, 1, 1, 1, 1])); // true
}
