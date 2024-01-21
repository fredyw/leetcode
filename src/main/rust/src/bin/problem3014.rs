// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/
pub fn minimum_pushes(word: String) -> i32 {
    let mut answer = 0;
    let mut length = word.len() as i32 - 8;
    let mut multiplier = 1;
    while length > 0 {
        answer += 8 * multiplier;
        length -= 8;
        multiplier += 1;
    }
    answer += (8 + length) * multiplier;
    answer
}

fn main() {
    println!("{}", minimum_pushes("abcde".to_string())); // 5
    println!("{}", minimum_pushes("xycdefghij".to_string())); // 12
    println!("{}", minimum_pushes("abcdefh".to_string())); // 8
}
