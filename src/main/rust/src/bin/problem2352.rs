// https://leetcode.com/problems/equal-row-and-column-pairs/
pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        equal_pairs(vec![vec![3, 2, 1], vec![1, 7, 6], vec![2, 7, 7]])
    ); // 1
    println!(
        "{}",
        equal_pairs(vec![
            vec![3, 1, 2, 2],
            vec![1, 4, 4, 5],
            vec![2, 4, 2, 2],
            vec![2, 4, 2, 2]
        ])
    ); // 3
}
