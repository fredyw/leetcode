// https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/
pub fn is_winner(player1: Vec<i32>, player2: Vec<i32>) -> i32 {
    fn get_score(player: &Vec<i32>) -> i32 {
        let mut total_score = 0;
        let mut multiply_by_two_index = 0;
        for (i, score) in player.into_iter().enumerate() {
            if i != 0 && i <= multiply_by_two_index {
                total_score += 2 * score;
            } else {
                total_score += score;
            }
            if *score == 10 {
                multiply_by_two_index = i + 2;
            }
        }
        total_score
    }

    let player1_score = get_score(&player1);
    let player2_score = get_score(&player2);
    if player1_score > player2_score {
        1
    } else if player1_score < player2_score {
        2
    } else {
        0
    }
}

fn main() {
    println!("{}", is_winner(vec![4, 10, 7, 9], vec![6, 5, 2, 3])); // 1
    println!("{}", is_winner(vec![3, 5, 7, 6], vec![8, 10, 10, 2])); // 2
    println!("{}", is_winner(vec![3, 5, 7, 6, 3], vec![8, 10, 10, 2, 3])); // 2
    println!("{}", is_winner(vec![2, 3], vec![4, 1])); // 0
}
