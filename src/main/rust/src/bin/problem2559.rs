// https://leetcode.com/problems/count-vowel-strings-in-ranges/
pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        vowel_strings(
            vec![
                "aba".to_string(),
                "bcb".to_string(),
                "ece".to_string(),
                "aa".to_string(),
                "e".to_string()
            ],
            vec![vec![0, 2], vec![1, 4], vec![1, 1]]
        )
    ); // [2,3,0]
    println!(
        "{:?}",
        vowel_strings(
            vec!["a".to_string(), "e".to_string(), "i".to_string()],
            vec![vec![0, 2], vec![0, 1], vec![2, 2]]
        )
    ); // [3,2,1]
}
