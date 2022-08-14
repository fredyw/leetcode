// https://leetcode.com/problems/largest-local-values-in-a-matrix/
pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let n = grid.len();
    let mut answer = vec![vec![0; n - 2]; n - 2];
    for i in 0..(n - 2) {
        for j in 0..(n - 2) {
            let mut max = 0;
            for row in i..(i + 3) {
                for col in j..(j + 3) {
                    max = max.max(grid[row][col]);
                }
            }
            answer[i][j] = max;
        }
    }
    answer
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
