//https://leetcode.com/problems/number-of-distinct-islands/description/
pub fn num_distinct_islands(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        num_distinct_islands(vec![
            vec![1, 1, 0, 0, 0],
            vec![1, 1, 0, 0, 0],
            vec![0, 0, 0, 1, 1],
            vec![0, 0, 0, 1, 1]
        ])
    ); // 1
    println!(
        "{}",
        num_distinct_islands(vec![
            vec![1, 1, 0, 1, 1],
            vec![1, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 1],
            vec![1, 1, 0, 1, 1]
        ])
    ); // 3
}
