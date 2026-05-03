// https://leetcode.com/problems/count-indices-with-opposite-parity/description/
pub fn count_opposite_parity(nums: Vec<i32>) -> Vec<i32> {
    let mut num_odds = vec![0; nums.len()];
    let mut num_evens = vec![0; nums.len()];
    for (i, &n) in nums.iter().enumerate().rev() {
        if i == nums.len() - 1 {
            if n % 2 == 0 {
                num_evens[i] = 1;
            } else {
                num_odds[i] = 1;
            }
        } else {
            num_evens[i] = num_evens[i + 1] + if n % 2 == 0 { 1 } else { 0 };
            num_odds[i] = num_odds[i + 1] + if n % 2 == 0 { 0 } else { 1 };
        }
    }
    let mut answer = vec![0; nums.len()];
    for i in 0..nums.len() - 1 {
        if nums[i] % 2 == 0 {
            answer[i] = num_odds[i + 1];
        } else {
            answer[i] = num_evens[i + 1];
        }
    }
    answer
}

fn main() {
    println!("{:?}", count_opposite_parity(vec![1, 2, 3, 4])); // [2,1,1,0]
    println!("{:?}", count_opposite_parity(vec![1])); // [0]
}
