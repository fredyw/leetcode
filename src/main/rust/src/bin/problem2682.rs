// https://leetcode.com/problems/find-the-losers-of-the-circular-game/
pub fn circular_game_losers(n: i32, k: i32) -> Vec<i32> {
    let mut visited: Vec<bool> = vec![false; n as usize];
    let mut friend = 0;
    let mut i: i32 = 1;
    visited[friend as usize] = true;
    loop {
        friend = (friend + (i * k)) % n;
        if visited[friend as usize] {
            break;
        }
        visited[friend as usize] = true;
        i += 1;
    }
    visited
        .into_iter()
        .enumerate()
        .filter(|(i, v)| *i > 0 && !*v)
        .map(|(i, _)| i as i32 + 1)
        .collect()
}

fn main() {
    println!("{:?}", circular_game_losers(5, 2)); // [4,5]
    println!("{:?}", circular_game_losers(4, 4)); // [2,3,4]
    println!("{:?}", circular_game_losers(2, 1)); // []
}
