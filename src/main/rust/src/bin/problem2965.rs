// https://leetcode.com/problems/find-missing-and-repeated-values/description/
pub fn find_missing_and_repeated_values(grid: Vec<Vec<i32>>) -> Vec<i32> {
    let mut answer = vec![0; 2];
    let mut nums = vec![0; (grid.len() * grid.len()) + 1];
    for i in 0..grid.len() {
        for j in 0..grid[i].len() {
            nums[grid[i][j] as usize] += 1;
        }
    }
    for i in 1..nums.len() {
        if nums[i] > 1 {
            answer[0] = i as i32;
        } else if nums[i] == 0 {
            answer[1] = i as i32;
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        find_missing_and_repeated_values(vec![vec![1, 3], vec![2, 2]])
    ); // [2,4]
    println!(
        "{:?}",
        find_missing_and_repeated_values(vec![vec![9, 1, 7], vec![8, 9, 2], vec![3, 4, 6]])
    ); // [9,5]
}
