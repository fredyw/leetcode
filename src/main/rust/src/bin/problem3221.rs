// https://leetcode.com/problems/maximum-array-hopping-score-ii
pub fn max_score(nums: Vec<i32>) -> i64 {
    let mut suffix_max: Vec<(usize, i32)> = vec![(0, 0); nums.len()];
    for i in (0..nums.len()).rev() {
        if i == nums.len() - 1 {
            suffix_max[i] = (i, nums[i]);
        } else {
            if suffix_max[i + 1].1 > nums[i] {
                suffix_max[i] = suffix_max[i + 1];
            } else {
                suffix_max[i] = (i, nums[i]);
            }
        }
    }
    let mut answer = 0;
    let mut i = 0;
    let mut j = suffix_max[0].0;
    while j < suffix_max.len() {
        answer += (j as i64 - i as i64) * suffix_max[j].1 as i64;
        if j + 1 >= suffix_max.len() {
            break;
        }
        i = j;
        j = suffix_max[j + 1].0;
    }
    answer
}

fn main() {
    println!("{}", max_score(vec![1, 5, 8])); // 16
    println!("{}", max_score(vec![4, 5, 2, 8, 9, 1, 3])); // 42
}
