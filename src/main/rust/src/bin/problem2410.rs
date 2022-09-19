// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
pub fn match_players_and_trainers(mut players: Vec<i32>, mut trainers: Vec<i32>) -> i32 {
    players.sort();
    trainers.sort();
    let mut answer = 0;
    let mut i = 0;
    let mut j = 0;
    while i < players.len() && j < trainers.len() {
        while j < trainers.len() && players[i] > trainers[j] {
            j += 1;
        }
        if j < trainers.len() {
            answer += 1;
        }
        i += 1;
        j += 1;
    }
    answer
}

fn main() {
    println!(
        "{}",
        match_players_and_trainers(vec![4, 7, 9], vec![8, 2, 5, 8])
    ); // 2
    println!("{}", match_players_and_trainers(vec![1, 1, 1], vec![10])); // 1
    println!(
        "{}",
        match_players_and_trainers(vec![4, 7, 9], vec![1, 2, 3])
    ); // 0
}
