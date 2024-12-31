use std::collections::{BTreeMap, HashMap};

// https://leetcode.com/problems/design-a-leaderboard/
struct Leaderboard {
    players: HashMap<i32, i32>,
    scores: BTreeMap<i32, i32>,
}

impl Leaderboard {
    fn new() -> Self {
        Self {
            players: HashMap::new(),
            scores: BTreeMap::new(),
        }
    }

    fn add_score(&mut self, player_id: i32, score: i32) {
        if let Some(s) = self.players.get_mut(&player_id) {
            if let Some(c) = self.scores.get_mut(s) {
                *c -= 1;
                if *c == 0 {
                    self.scores.remove(s);
                }
            }
            *s += score;
            *self.scores.entry(*s).or_insert(0) += 1;
        } else {
            self.players.insert(player_id, score);
            *self.scores.entry(score).or_insert(0) += 1;
        }
    }

    fn top(&self, k: i32) -> i32 {
        let mut sum = 0;
        let mut i = 0;
        for (score, count) in self.scores.iter().rev() {
            if i + count <= k {
                sum += *score * *count;
                i += count;
            } else {
                sum += *score * (i + count - k);
                i += i + count - k;
            }
            if i == k {
                break;
            }
        }
        sum
    }

    fn reset(&mut self, player_id: i32) {
        if let Some(s) = self.players.get(&player_id) {
            if let Some(c) = self.scores.get_mut(s) {
                *c -= 1;
                if *c == 0 {
                    self.scores.remove(s);
                }
            }
        }
        self.players.remove(&player_id);
    }
}

fn main() {
    let mut leaderboard = Leaderboard::new();
    leaderboard.add_score(1, 73);
    leaderboard.add_score(2, 56);
    leaderboard.add_score(3, 39);
    leaderboard.add_score(4, 51);
    leaderboard.add_score(5, 4);
    println!("{}", leaderboard.top(1)); // 73
    println!("{}", leaderboard.top(3)); // 180
    leaderboard.reset(1);
    leaderboard.reset(2);
    leaderboard.add_score(2, 51);
    println!("{}", leaderboard.top(3)); // 141

    let mut leaderboard = Leaderboard::new();
    leaderboard.add_score(1, 13);
    leaderboard.add_score(2, 93);
    leaderboard.add_score(3, 84);
    leaderboard.add_score(4, 6);
    leaderboard.add_score(5, 89);
    leaderboard.add_score(6, 31);
    leaderboard.add_score(7, 7);
    leaderboard.add_score(8, 1);
    leaderboard.add_score(9, 98);
    leaderboard.add_score(10, 42);
    println!("{}", leaderboard.top(5)); // 406
    leaderboard.reset(1);
    leaderboard.reset(2);
    leaderboard.add_score(3, 76);
    leaderboard.add_score(4, 68);
    println!("{}", leaderboard.top(1)); // 160
}
