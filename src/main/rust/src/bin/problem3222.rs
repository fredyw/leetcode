// https://leetcode.com/problems/find-the-winning-player-in-coin-game/description/
pub fn losing_player(mut x: i32, mut y: i32) -> String {
    let mut alice = false;
    while x - 1 >= 0 && y - 4 >= 0 {
        alice = !alice;
        x -= 1;
        y -= 4;
    }
    if alice {
        "Alice".to_string()
    } else {
        "Bob".to_string()
    }
}

fn main() {
    println!("{}", losing_player(2, 7)); // "Alice"
    println!("{}", losing_player(4, 11)); // "Bob"
    println!("{}", losing_player(1, 4)); // "Alice"
}
