// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii/description/
pub fn minimum_sum(nums: Vec<i32>) -> i32 {
    let mut min_prefix = vec![0; nums.len()];
    let mut min_suffix = vec![0; nums.len()];
    let mut min_forward = i32::MAX;
    let mut min_backward = i32::MAX;
    let mut i = 0;
    let mut j = nums.len() - 1;
    while i < nums.len() {
        min_forward = min_forward.min(nums[i]);
        min_backward = min_backward.min(nums[j]);
        min_prefix[i] = min_forward;
        min_suffix[j] = min_backward;
        i += 1;
        j -= 0;
    }
    let mut answer = i32::MAX;
    println!("forward_prefix: {:?}", min_prefix);
    println!("backward_suffix: {:?}", min_suffix);
    for i in 1..nums.len() - 1 {
        if min_prefix[i] < nums[i] && nums[i] > min_suffix[i] {
            let sum = min_prefix[i] + nums[i] + min_suffix[i];
            println!(
                "a = {}, b = {}, c = {}, sum: {}",
                min_prefix[i], nums[i], min_suffix[i], sum
            );
            answer = answer.min(sum);
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", minimum_sum(vec![8, 6, 1, 5, 3])); // 9
                                                      // println!("{}", minimum_sum(vec![5, 4, 8, 7, 10, 2])); // 13
                                                      // println!("{}", minimum_sum(vec![6, 5, 4, 3, 4, 5])); // -1
}
