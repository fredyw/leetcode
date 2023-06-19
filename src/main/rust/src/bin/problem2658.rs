// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
pub fn find_max_fish(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        find_max_fish(vec![
            vec![0, 2, 1, 0],
            vec![4, 0, 0, 3],
            vec![1, 0, 0, 4],
            vec![0, 3, 2, 0]
        ])
    ); // 7
    println!(
        "{}",
        find_max_fish(vec![
            vec![1, 0, 0, 0],
            vec![0, 0, 0, 0],
            vec![0, 0, 0, 0],
            vec![0, 0, 0, 1]
        ])
    ); // 1
}
