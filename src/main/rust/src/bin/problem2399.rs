// https://leetcode.com/problems/check-distances-between-same-letters/
pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        check_distances(
            "abaccb".to_string(),
            vec![1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        )
    ); // true
    println!(
        "{}",
        check_distances(
            "aa".to_string(),
            vec![1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        )
    ); // false
}
