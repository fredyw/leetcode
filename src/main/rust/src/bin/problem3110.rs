// https://leetcode.com/problems/score-of-a-string/description/
pub fn score_of_string(s: String) -> i32 {
    let mut answer = 0;
    let bytes = s.as_bytes();
    for i in 0..s.len() - 1 {
        answer += (bytes[i] as i32 - bytes[i + 1] as i32).abs();
    }
    answer
}

fn main() {
    println!("{}", score_of_string("hello".to_string())); // 13
    println!("{}", score_of_string("zaz".to_string())); // 50
}
