// https://leetcode.com/problems/number-of-spaces-cleaning-robot-cleaned/description/
pub fn number_of_clean_rooms(room: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        number_of_clean_rooms(vec![vec![0, 0, 0], vec![1, 1, 0], vec![0, 0, 0]])
    ); // 7
    println!(
        "{}",
        number_of_clean_rooms(vec![vec![0, 1, 0], vec![1, 0, 0], vec![0, 0, 0]])
    ); // 1
    println!(
        "{}",
        number_of_clean_rooms(vec![vec![0, 0, 0], vec![0, 0, 0], vec![0, 0, 0]])
    ); // 0
    println!(
        "{}",
        number_of_clean_rooms(vec![vec![0, 0, 0], vec![1, 0, 0], vec![0, 0, 0]])
    ); // 7
}
