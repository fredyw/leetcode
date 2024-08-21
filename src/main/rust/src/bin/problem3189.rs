// https://leetcode.com/problems/minimum-moves-to-get-a-peaceful-board/description/
pub fn min_moves(mut rooks: Vec<Vec<i32>>) -> i32 {
    rooks.sort_by(|a, b| a[0].cmp(&b[0]));
    let mut answer = 0;
    for i in (0..rooks.len()).rev() {
        answer += (i as i32 - rooks[i][0]).abs();
    }
    rooks.sort_by(|a, b| a[1].cmp(&b[1]));
    for i in (0..rooks.len()).rev() {
        answer += (i as i32 - rooks[i][1]).abs();
    }
    answer
}

fn main() {
    println!("{}", min_moves(vec![vec![0, 0], vec![1, 0], vec![1, 1]])); // 3
    println!(
        "{}",
        min_moves(vec![vec![0, 0], vec![0, 1], vec![0, 2], vec![0, 3]])
    ); // 6
    println!(
        "{}",
        min_moves(vec![
            vec![0, 0],
            vec![0, 1],
            vec![1, 0],
            vec![1, 1],
            vec![4, 4]
        ])
    ); // 8
    println!(
        "{}",
        min_moves(vec![
            vec![1, 2],
            vec![2, 1],
            vec![2, 2],
            vec![2, 3],
            vec![3, 2]
        ])
    ); // 8
    println!(
        "{}",
        min_moves(vec![
            vec![0, 0],
            vec![1, 3],
            vec![4, 1],
            vec![2, 4],
            vec![2, 0]
        ])
    ); // 3
}
