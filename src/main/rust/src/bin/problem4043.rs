// https://leetcode.com/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/description/
pub fn count_rotations(s: String, k: i32) -> i32 {
    let bytes = s.as_bytes();
    let n = bytes.len();
    let mut total_matches = 0;
    for i in 0..n {
        if bytes[i] == bytes[(i + 1) % n] {
            total_matches += 1;
        }
    }
    let mut answer = 0;
    for i in 0..n {
        let score = if bytes[(i + n - 1) % n] == bytes[i] {
            total_matches - 1
        } else {
            total_matches
        };
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
