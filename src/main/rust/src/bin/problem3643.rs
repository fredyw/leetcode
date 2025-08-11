// https://leetcode.com/problems/flip-square-submatrix-vertically/description/
pub fn reverse_submatrix(grid: Vec<Vec<i32>>, x: i32, y: i32, k: i32) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        reverse_submatrix(
            vec![
                vec![1, 2, 3, 4],
                vec![5, 6, 7, 8],
                vec![9, 10, 11, 12],
                vec![13, 14, 15, 16]
            ],
            1,
            0,
            3
        )
    ); // [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]
    println!(
        "{:?}",
        reverse_submatrix(vec![vec![3, 4, 2, 3], vec![2, 3, 4, 2]], 0, 2, 2)
    ); // [[3,4,4,2],[2,3,2,3]]
}
