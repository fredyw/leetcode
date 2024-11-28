// https://leetcode.com/problems/minimum-positive-sum-subarray/description/
pub fn minimum_sum_subarray(nums: Vec<i32>, l: i32, r: i32) -> i32 {
    let mut answer = i32::MAX;
    for i in 0..nums.len() {
        let mut sum = 0;
        for j in i..nums.len() {
            let length = j as i32 - i as i32 + 1;
            sum += nums[j];
            if length >= l && length <= r {
                if sum > 0 {
                    answer = answer.min(sum);
                }
            }
            if length > r {
                break;
            }
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", minimum_sum_subarray(vec![3, -2, 1, 4], 2, 3)); // 1
    println!("{}", minimum_sum_subarray(vec![-2, 2, -3, 1], 2, 3)); // -1
    println!("{}", minimum_sum_subarray(vec![1, 2, 3, 4], 2, 4)); // 3
    println!("{}", minimum_sum_subarray(vec![17, 13], 1, 2)); // 13
    println!("{}", minimum_sum_subarray(vec![-23, 2, -12], 1, 2)); // 2
    println!("{}", minimum_sum_subarray(vec![6, 19, 4], 2, 2)); // 23
}
