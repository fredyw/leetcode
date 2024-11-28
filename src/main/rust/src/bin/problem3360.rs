// https://leetcode.com/problems/stone-removal-game/description/
pub fn can_alice_win(mut n: i32) -> bool {
    let mut alice = false;
    for i in (1..=10).rev() {
        if n - i < 0 {
            break;
        }
        alice = !alice;
        n -= i;
    }
    alice
}

fn main() {
    println!("{}", can_alice_win(12)); // true
    println!("{}", can_alice_win(1)); // false
}
