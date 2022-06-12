// https://leetcode.com/problems/minimum-path-cost-in-a-grid/
pub fn min_path_cost(grid: Vec<Vec<i32>>, move_cost: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_path_cost(
            vec![
                vec![5, 3],
                vec![4, 0],
                vec![2, 1]
            ],
            vec![
                vec![9, 8],
                vec![1, 5],
                vec![10, 12],
                vec![18, 6],
                vec![2, 4],
                vec![14, 3]
            ]
        )
    ); // 17
    println!(
        "{}",
        min_path_cost(
            vec![
                vec![5, 1, 2],
                vec![4, 0, 3]
            ],
            vec![
                vec![12, 10, 15],
                vec![20, 23, 8],
                vec![21, 7, 1],
                vec![8, 1, 13],
                vec![9, 10, 25],
                vec![5, 3, 2]
            ]
        )
    ); // 6
}
