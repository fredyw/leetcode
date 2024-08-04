// https://leetcode.com/problems/find-the-number-of-winning-players/
pub fn winning_player_count(n: i32, pick: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        winning_player_count(
            4,
            vec![
                vec![0, 0],
                vec![1, 0],
                vec![1, 0],
                vec![2, 1],
                vec![2, 1],
                vec![2, 0]
            ]
        )
    ); // 2
    println!(
        "{}",
        winning_player_count(5, vec![vec![1, 1], vec![1, 2], vec![1, 3], vec![1, 4]])
    ); // 0
    println!(
        "{}",
        winning_player_count(5, vec![vec![1, 1], vec![2, 4], vec![2, 4], vec![2, 4]])
    ); // 1
}
