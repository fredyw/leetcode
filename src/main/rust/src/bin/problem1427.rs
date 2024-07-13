// https://leetcode.com/problems/perform-string-shifts/description/
pub fn string_shift(s: String, shift: Vec<Vec<i32>>) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        string_shift("abc".to_string(), vec![vec![0, 1], vec![1, 2]])
    ); // "cab"
    println!(
        "{}",
        string_shift(
            "abcdefg".to_string(),
            vec![vec![1, 1], vec![1, 1], vec![0, 2], vec![1, 3]]
        )
    ); // "efgabcd"
}
