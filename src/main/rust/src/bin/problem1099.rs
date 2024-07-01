// https://leetcode.com/problems/two-sum-less-than-k/
pub fn two_sum_less_than_k(mut nums: Vec<i32>, k: i32) -> i32 {
    nums.sort();
    let mut answer = -1;
    for (i, num) in nums.iter().enumerate() {
        match nums.binary_search(&(k - *num)) {
            Ok(j) => {
                let mut j = j as isize - 1;
                while j >= 0 && nums[j as usize] == (k - *num) {
                    j -= 1;
                }
                if j >= 0 {
                    if i != j as usize {
                        answer = answer.max(*num + nums[j as usize]);
                    }
                }
            }
            Err(j) => {
                let mut j = j as isize - 1;
                while j >= 0 && nums[j as usize] == (k - *num) {
                    j -= 1;
                }
                if j >= 0 {
                    if i != j as usize {
                        answer = answer.max(*num + nums[j as usize]);
                    }
                }
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        two_sum_less_than_k(vec![34, 23, 1, 24, 75, 33, 54, 8], 60)
    ); // 58
    println!("{}", two_sum_less_than_k(vec![10, 20, 30], 15)); // -1
    println!("{}", two_sum_less_than_k(vec![1, 1], 2)); // -1
    println!(
        "{}",
        two_sum_less_than_k(vec![1, 30, 6, 89, 15, 49, 28, 45, 33], 15)
    ); // 7
}
