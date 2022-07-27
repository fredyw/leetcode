// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
    let mut answer: i64 = 0;
    let mut odd_sum: i64 = 0;
    let mut even_sum: i64 = 1;
    let mut current_sum: i64 = 0;
    for i in 0..arr.len() {
        current_sum += arr[i] as i64;
        if current_sum % 2 == 0 {
            even_sum += 1;
            answer += odd_sum;
        } else {
            odd_sum += 1;
            answer += even_sum;
        }
    }
    (answer % 1_000_000_007) as i32
}

fn main() {
    println!("{}", num_of_subarrays(vec![1, 3, 5])); // 4
    println!("{}", num_of_subarrays(vec![2, 4, 6])); // 0
    println!("{}", num_of_subarrays(vec![1, 2, 3, 4, 5, 6, 7])); // 16
}
