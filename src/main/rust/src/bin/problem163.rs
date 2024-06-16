// https://leetcode.com/problems/missing-ranges/
pub fn find_missing_ranges(nums: Vec<i32>, lower: i32, upper: i32) -> Vec<Vec<i32>> {
    let mut answer: Vec<Vec<i32>> = vec![];
    if nums.is_empty() {
        return vec![vec![lower, upper]];
    }
    if nums.len() > 0 {
        if nums[0] != lower {
            answer.push(vec![lower, nums[0] - 1]);
        }
    }
    let mut i = 0;
    while i < nums.len() - 1 {
        if nums[i] + 1 != nums[i + 1] {
            answer.push(vec![nums[i] + 1, nums[i + 1] - 1]);
        }
        i += 1;
    }
    if nums[nums.len() - 1] != upper {
        answer.push(vec![nums[nums.len() - 1] + 1, upper]);
    }
    answer
}

fn main() {
    println!("{:?}", find_missing_ranges(vec![0, 1, 3, 50, 75], 0, 99)); // [[2,2],[4,49],[51,74],[76,99]]
    println!("{:?}", find_missing_ranges(vec![-1], -1, -1)); // []
    println!("{:?}", find_missing_ranges(vec![], 0, 1)); // [[0,1]]
}
