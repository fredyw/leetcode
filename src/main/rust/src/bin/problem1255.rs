// https://leetcode.com/problems/maximum-score-words-formed-by-letters/
pub fn max_score_words(words: Vec<String>, letters: Vec<char>, score: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_score_words(
            vec![
                String::from("dog"),
                String::from("cat"),
                String::from("dad"),
                String::from("good")
            ],
            vec!['a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'],
            vec![1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        )
    ); // 23
    println!(
        "{}",
        max_score_words(
            vec![
                String::from("xxxz"),
                String::from("ax"),
                String::from("bx"),
                String::from("cx")
            ],
            vec!['z', 'a', 'b', 'c', 'x', 'x', 'x'],
            vec![4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10]
        )
    ); // 27
    println!(
        "{}",
        max_score_words(
            vec![String::from("leetcode")],
            vec!['l', 'e', 't', 'c', 'o', 'd'],
            vec![0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
        )
    ); // 0
}
