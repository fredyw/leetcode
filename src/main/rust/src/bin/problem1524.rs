// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
    let mut answer: i64 = 0;
    for i in 0..arr.len() {
        let mut sum = 0;
        for j in i..arr.len() {
            sum += arr[j];
            if sum % 2 != 0 {
                answer += 1;
            }
        }
    }
    (answer % 1_000_000_007) as i32
}

fn main() {
    println!("{}", num_of_subarrays(vec![1, 3, 5])); // 4
    println!("{}", num_of_subarrays(vec![2, 4, 6])); // 0
    println!("{}", num_of_subarrays(vec![1, 2, 3, 4, 5, 6, 7])); // 16
}
