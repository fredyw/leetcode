// https://leetcode.com/problems/prime-in-diagonal/
pub fn diagonal_prime(nums: Vec<Vec<i32>>) -> i32 {
    fn is_prime(n: i32) -> bool {
        if n == 1 {
            return false;
        }
        if n == 2 {
            return true;
        }
        for i in 2..=(n as f64).sqrt() as i32 {
            if n % i as i32 == 0 {
                return false;
            }
        }
        true
    }

    let mut answer = 0;
    let mut row: i32 = 0;
    let mut col1: i32 = 0;
    let mut col2: i32 = if nums.len() > 0 { nums[0].len() - 1 } else { 0 } as i32;
    while row < nums.len() as i32 {
        if is_prime(nums[row as usize][col1 as usize]) {
            answer = answer.max(nums[row as usize][col1 as usize]);
        }
        if is_prime(nums[row as usize][col2 as usize]) {
            answer = answer.max(nums[row as usize][col2 as usize]);
        }
        row += 1;
        col1 += 1;
        col2 -= 1;
    }
    answer
}

fn main() {
    println!(
        "{}",
        diagonal_prime(vec![vec![1, 2, 3], vec![5, 6, 7], vec![9, 10, 11]])
    ); // 11
    println!(
        "{}",
        diagonal_prime(vec![vec![1, 2, 3], vec![5, 17, 7], vec![9, 11, 10]])
    ); // 17
}
