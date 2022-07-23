// https://leetcode.com/problems/best-poker-hand/
pub fn best_hand(ranks: Vec<i32>, suits: Vec<char>) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        best_hand(vec![13, 2, 3, 1, 9], vec!['a', 'a', 'a', 'a', 'a'])
    ); // "Flush"
    println!(
        "{}",
        best_hand(vec![4, 4, 2, 4, 4], vec!['d', 'a', 'a', 'b', 'c'])
    ); // "Three of a Kind"
    println!(
        "{}",
        best_hand(vec![10, 10, 2, 12, 9], vec!['a', 'b', 'c', 'a', 'd'])
    ); // "Pair"
}
