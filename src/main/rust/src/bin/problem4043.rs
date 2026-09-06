// https://leetcode.com/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/description/
pub fn count_rotations(s: String, k: i32) -> i32 {
    let chars: Vec<char> = s.chars().collect();
    let mut answer = 0;
    for i in 0..chars.len() {
        let mut score = 0;
        for j in i..(i + chars.len() - 1) {
            if chars[j % chars.len()] == chars[(j + 1) % chars.len()] {
                score += 1;
            }
        }
        if score == k {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_rotations("aab".to_string(), 1)); // 2
    println!("{}", count_rotations("abca".to_string(), 0)); // 1
    println!("{}", count_rotations("aaaa".to_string(), 0)); // 0
    println!("{}", count_rotations("aabbcc".to_string(), 1)); // 0
}
