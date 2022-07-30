// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
pub fn get_max_len(nums: Vec<i32>) -> i32 {
    fn max_len(i: i32, j: i32, first_neg_idx: i32, last_neg_idx: i32, product: i32) -> i32 {
        let mut max_len = 0;
        if j as i32 - 1 >= i as i32 {
            if product > 0 {
                // If the product of a subarray is positive, then max length is the length of
                // the subarray.
                max_len = j as i32 - i;
            } else {
                // if the product of a subarray is negative, there can only be two choices.
                // 1. first_neg_idx + 1 to j
                // 2. i to last_neg_idx - 1
                max_len = (last_neg_idx - i).max(j as i32 - (first_neg_idx + 1));
            }
        }
        max_len
    }

    let mut answer: i32 = 0;
    let mut first_neg_idx: i32 = -1;
    let mut last_neg_idx: i32 = -1;
    let mut product = 1;
    let mut i = 0;
    let mut j = 0;
    while j < nums.len() {
        if nums[j] == 0 {
            answer = answer.max(max_len(i, j as i32, first_neg_idx, last_neg_idx, product));
        }
        while j < nums.len() && nums[j] == 0 {
            first_neg_idx = -1;
            last_neg_idx = -1;
            product = 1;
            j += 1;
            i = j as i32;
        }
        if j == nums.len() {
            break;
        }
        if nums[j] < 0 {
            if first_neg_idx == -1 {
                first_neg_idx = j as i32;
            }
            last_neg_idx = j as i32;
        }
        // We don't actually care about the real product. We just want to know if the product of a
        // subarray is positive or negative. So using 1 and -1 to avoid overflowing.
        product *= if nums[j] > 0 { 1 } else { -1 };
        j += 1;
    }
    answer.max(max_len(i, j as i32, first_neg_idx, last_neg_idx, product))
}

fn main() {
    println!("{}", get_max_len(vec![1, -2, -3, 4])); // 4
    println!("{}", get_max_len(vec![0, 1, -2, -3, -4])); // 3
    println!("{}", get_max_len(vec![-1, -2, -3, 0, 1])); // 2
    println!(
        "{}",
        get_max_len(vec![-1, -2, -3, 0, 0, 0, 1, 0, 0, -3, -5, -2, 1, 3])
    ); // 4
    println!("{}", get_max_len(vec![0, 0, 0, 0])); // 0
    println!("{}", get_max_len(vec![0, -1, -2, -3, -4])); // 4
    println!("{}", get_max_len(vec![-1000000000, -1000000000])); // 2
    println!(
        "{}",
        get_max_len(vec![
            70, -18, 75, -72, -69, -84, 64, -65, 0, -82, 62, 54, -63, -85, 53, -60, -59, 29, 32,
            59, -54, -29, -45, 0, -10, 22, 42, -37, -16, 0, -7, -76, -34, 37, -10, 2, -59, -24, 85,
            45, -81, 56, 86
        ])
    ); // 14
}
