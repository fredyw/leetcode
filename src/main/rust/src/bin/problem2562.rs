// https://leetcode.com/problems/find-the-array-concatenation-value/
pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
    let mut answer = 0;
    let mut i = 0;
    let mut j = nums.len() - 1;
    while i < j {
        answer += format!("{}{}", nums[i], nums[j]).parse::<i64>().unwrap();
        i += 1;
        j -= 1;
    }
    if i == j {
        answer += nums[i] as i64;
    }
    answer
}

fn main() {
    println!("{}", find_the_array_conc_val(vec![7, 52, 2, 4])); // 596
    println!("{}", find_the_array_conc_val(vec![5, 14, 13, 8, 12])); // 673
}
