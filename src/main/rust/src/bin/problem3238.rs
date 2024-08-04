use std::collections::HashMap;

// https://leetcode.com/problems/find-the-number-of-winning-players/
pub fn winning_player_count(n: i32, pick: Vec<Vec<i32>>) -> i32 {
    let mut map: HashMap<i32, HashMap<i32, i32>> = HashMap::new();
    let mut max: Vec<i32> = vec![0; n as usize];
    for p in pick {
        let player = p[0];
        let color = p[1];
        let m = map.entry(player).or_insert(HashMap::new());
        let count = m.entry(color).or_insert(0);
        *count += 1;
        max[player as usize] = max[player as usize].max(*count);
    }
    let mut answer = 0;
    for i in 0..n {
        let count = max[i as usize];
        if count >= i + 1 {
            answer += 1;
        }
    }
    answer
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
