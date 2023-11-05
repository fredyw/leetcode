// https://leetcode.com/problems/find-champion-i/description/
pub fn find_champion(grid: Vec<Vec<i32>>) -> i32 {
    let mut answer = 0;
    let mut max = 0;
    for i in 0..grid.len() {
        let mut count = 0;
        for j in 0..grid[i].len() {
            count += grid[i][j];
        }
        if count >= max {
            max = count;
            answer = i as i32;
        }
    }
    answer
}

fn main() {
    println!("{}", find_champion(vec![vec![0, 1], vec![0, 0]])); // 0
    println!(
        "{}",
        find_champion(vec![vec![0, 0, 1], vec![1, 0, 1], vec![0, 0, 0]])
    ); // 1
}
