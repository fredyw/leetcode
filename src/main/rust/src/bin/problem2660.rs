// https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/
pub fn is_winner(player1: Vec<i32>, player2: Vec<i32>) -> i32 {
    fn get_total(player: &Vec<i32>) -> i32 {
        todo!()
    }

    let total_player1 = get_total(&player1);
    let total_player2 = get_total(&player2);
    for i in 0..player2.len() {}
    if total_player1 > total_player2 {
        1
    } else if total_player1 < total_player2 {
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
