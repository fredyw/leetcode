// https://leetcode.com/problems/find-the-score-difference-in-a-game/
pub fn score_difference(nums: Vec<i32>) -> i32 {
    let mut player1 = true;
    let mut player1_score = 0;
    let mut player2_score = 0;
    for (i, num) in nums.iter().enumerate() {
        if num % 2 != 0 {
            player1 = !player1;
        }
        if (i + 1) % 6 == 0 {
            player1 = !player1;
        }
        if player1 {
            player1_score += num;
        } else {
            player2_score += num;
        }
    }
    player1_score - player2_score
}

fn main() {
    println!("{}", score_difference(vec![1, 2, 3])); // 0
    println!("{}", score_difference(vec![2, 4, 2, 1, 2, 1])); // 4
    println!("{}", score_difference(vec![1])); // -1
}
