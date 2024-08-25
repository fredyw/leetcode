// https://leetcode.com/problems/fixed-point/description/
pub fn fixed_point(arr: Vec<i32>) -> i32 {
    for (i, n) in arr.iter().enumerate() {
        if i as i32 == *n {
            return *n;
        }
    }
    -1
}

fn main() {
    println!("{}", fixed_point(vec![-10, -5, 0, 3, 7])); // 3
    println!("{}", fixed_point(vec![0, 2, 5, 8, 17])); // 0
    println!("{}", fixed_point(vec![-10, -5, 3, 4, 7, 9])); // -1
}
