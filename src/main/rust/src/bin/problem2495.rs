// https://leetcode.com/problems/number-of-subarrays-having-even-product/description/
pub fn even_product(nums: Vec<i32>) -> i64 {
    let mut even_indexes: Vec<i64> = vec![-1; nums.len()];
    for i in (0..nums.len()).rev() {
        if nums[i] % 2 == 0 {
            even_indexes[i] = i as i64;
        } else {
            if i + 1 < even_indexes.len() {
                even_indexes[i] = even_indexes[i + 1];
            }
        }
    }
    let mut answer = 0;
    for i in 0..nums.len() {
        if even_indexes[i] != -1 {
            answer += nums.len() as i64 - even_indexes[i];
        }
    }
    answer
}

fn main() {
    println!("{}", even_product(vec![9, 6, 7, 13])); // 6
    println!("{}", even_product(vec![7, 3, 5])); // 0
}
