// https://leetcode.com/problems/minimum-moves-to-make-array-complementary/description/
pub fn min_moves(nums: Vec<i32>, limit: i32) -> i32 {
    todo!()
}

fn main() {
    println!("{}", min_moves(vec![1, 2, 4, 3], 4)); // 1
    println!("{}", min_moves(vec![1, 2, 2, 1], 2)); // 2
    println!("{}", min_moves(vec![1, 2, 1, 2], 2)); // 0
    println!("{}", min_moves(vec![5, 2, 1, 2, 3, 5], 5)); // 3
    println!("{}", min_moves(vec![5, 5, 2, 1, 2, 3, 4, 5], 5)); // 4
}
