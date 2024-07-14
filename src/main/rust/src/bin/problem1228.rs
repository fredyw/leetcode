// https://leetcode.com/problems/missing-number-in-arithmetic-progression/description/
pub fn missing_number(arr: Vec<i32>) -> i32 {
    let mut diff = 0;
    for i in 0..arr.len() - 1 {
        if diff == 0 {
            diff = arr[i + 1] - arr[i];
        } else {
            if i == 1 && diff.abs() > (arr[i + 1] - arr[i]).abs() {
                return arr[i - 1] + arr[i + 1] - arr[i];
            }
            if diff.abs() > (arr[i + 1] - arr[i]).abs() {
                return arr[i] + arr[i + 1] - arr[i];
            }
            if diff.abs() < (arr[i + 1] - arr[i]).abs() {
                return arr[i] + diff;
            }
        }
    }
    arr[0]
}

fn main() {
    println!("{}", missing_number(vec![5, 7, 11, 13])); // 9
    println!("{}", missing_number(vec![15, 13, 12])); // 14
    println!("{}", missing_number(vec![15, 13, 12, 11])); // 14
    println!("{}", missing_number(vec![15, 14, 12, 11])); // 13
    println!("{}", missing_number(vec![5, 9, 11, 13])); // 7
    println!("{}", missing_number(vec![1, 1, 1])); // 1
}
