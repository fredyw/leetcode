// https://leetcode.com/problems/find-the-closest-marked-node/description/
pub fn minimum_distance(n: i32, edges: Vec<Vec<i32>>, s: i32, marked: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        minimum_distance(
            4,
            vec![vec![0, 1, 1], vec![1, 2, 3], vec![2, 3, 2], vec![0, 3, 4]],
            0,
            vec![2, 3]
        )
    ); // 4
    println!(
        "{}",
        minimum_distance(
            5,
            vec![
                vec![0, 1, 2],
                vec![0, 2, 4],
                vec![1, 3, 1],
                vec![2, 3, 3],
                vec![3, 4, 2]
            ],
            1,
            vec![0, 4]
        )
    ); // 3
    println!(
        "{}",
        minimum_distance(
            4,
            vec![vec![0, 1, 1], vec![1, 2, 3], vec![2, 3, 2]],
            3,
            vec![0, 1]
        )
    ); // -1
}
