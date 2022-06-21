// https://leetcode.com/problems/number-of-wonderful-substrings/
pub fn wonderful_substrings(word: String) -> i64 {
    let mut answer = 0;
    let mut counts = vec![0; 1024]; // 1111111111 = 1023
    counts[0] = 1;
    let chars: Vec<char> = word.chars().collect();
    let mut current = 0;
    for c in chars {
        current ^= 1 << c as i32 - 'a' as i32;
        answer += counts[current];
        for j in 0..10 {
            let n = counts[current ^ (1 << j)];
            answer += n;
        }
        counts[current] += 1;
    }
    answer
}

fn main() {
    println!("{}", wonderful_substrings(String::from("aba"))); // 4
    println!("{}", wonderful_substrings(String::from("aabb"))); // 9
    println!("{}", wonderful_substrings(String::from("he"))); // 2
    println!("{}", wonderful_substrings(String::from("aabbc"))); // 12
}
