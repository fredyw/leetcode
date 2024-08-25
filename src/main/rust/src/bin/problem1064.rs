// https://leetcode.com/problems/fixed-point/description/
pub fn fixed_point(arr: Vec<i32>) -> i32 {
    let mut answer = -1;
    let mut left: i32 = 0;
    let mut right: i32 = arr.len() as i32 - 1;
    while left <= right {
        let mid = left + (right - left) / 2;
        if arr[mid as usize] == mid {
            answer = arr[mid as usize];
            right = mid - 1;
        } else if arr[mid as usize] < mid {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    answer
}

fn main() {
    println!("{}", fixed_point(vec![-10, -5, 0, 3, 7])); // 3
    println!("{}", fixed_point(vec![0, 2, 5, 8, 17])); // 0
    println!("{}", fixed_point(vec![-10, -5, 3, 4, 7, 9])); // -1
}
