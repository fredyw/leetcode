// https://leetcode.com/problems/largest-local-values-in-a-matrix/
pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        largest_local(vec![
            vec![9, 9, 8, 1],
            vec![5, 6, 2, 6],
            vec![8, 2, 6, 4],
            vec![6, 2, 2, 2]
        ])
    ); // [[9,9],[8,6]]
    println!(
        "{:?}",
        largest_local(vec![
            vec![1, 1, 1, 1, 1],
            vec![1, 1, 1, 1, 1],
            vec![1, 1, 2, 1, 1],
            vec![1, 1, 1, 1, 1],
            vec![1, 1, 1, 1, 1]
        ])
    ); // [[2,2,2],[2,2,2],[2,2,2]]
}
