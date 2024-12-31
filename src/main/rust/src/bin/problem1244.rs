// https://leetcode.com/problems/design-a-leaderboard/
struct Leaderboard {}

impl Leaderboard {
    fn new() -> Self {
        Self {}
    }

    fn add_score(&self, player_id: i32, score: i32) {
        todo!()
    }

    fn top(&self, k: i32) -> i32 {
        todo!()
    }

    fn reset(&self, player_id: i32) {
        todo!()
    }
}

fn main() {
    let leaderboard = Leaderboard::new();
    leaderboard.add_score(1, 73);
    leaderboard.add_score(2, 56);
    leaderboard.add_score(3, 39);
    leaderboard.add_score(4, 51);
    leaderboard.add_score(5, 4);
    leaderboard.top(1); // 73
    leaderboard.reset(1);
    leaderboard.reset(2);
    leaderboard.add_score(2, 51);
    println!("{}", leaderboard.top(3)); // 141
}
