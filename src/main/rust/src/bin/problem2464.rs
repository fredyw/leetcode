// https://leetcode.com/problems/minimum-subarrays-in-a-valid-split/description/
pub fn valid_subarray_split(nums: Vec<i32>) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            return a;
        }
        gcd(b, a % b)
    }

    fn valid_subarray_split(nums: &Vec<i32>, i: usize, memo: &mut Vec<i32>) -> i32 {
        if i == nums.len() {
            return 0;
        }
        if memo[i] != -1 {
            return memo[i];
        }
        let mut min = i32::MAX;
        for j in i..nums.len() {
            if gcd(nums[i], nums[j]) > 1 {
                let splits = valid_subarray_split(nums, j + 1, memo);
                if splits != i32::MAX {
                    min = min.min(splits + 1);
                }
            }
        }
        memo[i] = min;
        min
    }

    let answer = valid_subarray_split(&nums, 0, &mut vec![-1; nums.len()]);
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", valid_subarray_split(vec![2, 6, 3, 4, 3])); // 2
    println!("{}", valid_subarray_split(vec![3, 5])); // 2
    println!("{}", valid_subarray_split(vec![1, 2, 1])); // -1
}
