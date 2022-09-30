// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        number_of_weak_characters(vec![vec![5, 5], vec![6, 3], vec![3, 6]])
    ); // 0
    println!(
        "{}",
        number_of_weak_characters(vec![vec![2, 2], vec![3, 3]])
    ); // 1
    println!(
        "{}",
        number_of_weak_characters(vec![vec![1, 5], vec![10, 4], vec![4, 3]])
    ); // 1
    println!(
        "{}",
        number_of_weak_characters(vec![vec![1, 5], vec![10, 4], vec![4, 3], vec![5, 5]])
    ); // 1
}
