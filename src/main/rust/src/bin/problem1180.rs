// https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/description/
pub fn count_letters(s: String) -> i32 {
    let mut answer = 0;
    let bytes = s.as_bytes();
    let mut i = 0;
    while i < bytes.len() {
        let mut j = i + 1;
        while j < bytes.len() && bytes[i] == bytes[j] {
            j += 1;
        }
        answer += (1..=(j - i) as i32).into_iter().sum::<i32>();
        i = j;
    }
    answer
}

fn main() {
    println!("{}", count_letters("aaaba".to_string())); // 8
    println!("{}", count_letters("aaaaaaaaaa".to_string())); // 55
    println!("{}", count_letters("aaaa".to_string())); // 10
}
