// https://leetcode.com/problems/number-of-same-end-substrings/description/
pub fn same_end_substring_count(s: String, queries: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        same_end_substring_count(
            "abcaab".to_string(),
            vec![vec![0, 0], vec![1, 4], vec![2, 5], vec![0, 5]]
        )
    ); // [1,5,5,10]
    println!(
        "{:?}",
        same_end_substring_count("abcd".to_string(), vec![vec![0, 3]])
    ); // [4]
}
