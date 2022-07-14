// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
pub fn min_number_operations(target: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut previous = 0;
    for current in target {
        if current - previous > 0 {
            answer += current - previous;
        }
        previous = current;
    }
    answer
}

fn main() {
    println!("{}", min_number_operations(vec![1, 2, 3, 2, 1])); // 3
    println!("{}", min_number_operations(vec![3, 1, 1, 2])); // 4
    println!("{}", min_number_operations(vec![3, 1, 5, 4, 2])); // 7
}
