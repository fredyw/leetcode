// https://leetcode.com/problems/minimum-health-to-beat-game/description/
pub fn minimum_health(damage: Vec<i32>, armor: i32) -> i64 {
    let max: i64 = *damage.iter().max().unwrap() as i64;
    let sum: i64 = damage.iter().map(|n| *n as i64).sum();
    sum + 1
        - if armor as i64 > max {
            max
        } else {
            armor as i64
        }
}

fn main() {
    println!("{}", minimum_health(vec![2, 7, 4, 3], 4)); // 13
    println!("{}", minimum_health(vec![2, 5, 3, 4], 7)); // 10
    println!("{}", minimum_health(vec![3, 3, 3], 0)); // 10
}
