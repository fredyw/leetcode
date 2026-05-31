// https://leetcode.com/problems/minimum-moves-to-make-array-complementary/description/
pub fn min_moves(nums: Vec<i32>, limit: i32) -> i32 {
    let n = nums.len();
    let limit = limit as usize;
    let mut diff = vec![0; 2 * limit + 2];
    for i in 0..(n / 2) {
        let x = nums[i].min(nums[n - 1 - i]) as usize;
        let y = nums[i].max(nums[n - 1 - i]) as usize;
        diff[2] += 2;
        diff[x + 1] -= 2;
        diff[x + 1] += 1;
        diff[x + y] -= 1;
        diff[x + y + 1] += 1;
        diff[y + limit + 1] -= 1;
        diff[y + limit + 1] += 2;
        diff[2 * limit + 1] -= 2;
    }
    let mut answer = n as i32;
    let mut current_moves = 0;
    for x in 2..=(2 * limit) {
        current_moves += diff[x];
        answer = answer.min(current_moves);
    }
    answer
}

fn main() {
    println!("{}", min_moves(vec![1, 2, 4, 3], 4)); // 1
    println!("{}", min_moves(vec![1, 2, 2, 1], 2)); // 2
    println!("{}", min_moves(vec![1, 2, 1, 2], 2)); // 0
    println!("{}", min_moves(vec![5, 2, 1, 2, 3, 5], 5)); // 3
    println!("{}", min_moves(vec![5, 5, 2, 1, 2, 3, 4, 5], 5)); // 4
}
