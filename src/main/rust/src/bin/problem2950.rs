// https://leetcode.com/problems/number-of-divisible-substrings/description/
pub fn count_divisible_substrings(word: String) -> i32 {
    fn get_num(c: char) -> i32 {
        match c {
            'a' | 'b' => 1,
            'c' | 'd' | 'e' => 2,
            'f' | 'g' | 'h' => 3,
            'i' | 'j' | 'k' => 4,
            'l' | 'm' | 'n' => 5,
            'o' | 'p' | 'q' => 6,
            'r' | 's' | 't' => 7,
            'u' | 'v' | 'w' => 8,
            _ => 9,
        }
    }

    let chars: Vec<char> = word.chars().collect();
    let mut answer = 0;
    for i in 0..chars.len() {
        let mut sum = get_num(chars[i]);
        answer += 1;
        for j in i + 1..chars.len() {
            sum += get_num(chars[j]);
            if sum % (j - i + 1) as i32 == 0 {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_divisible_substrings("asdf".to_string())); // 6
    println!("{}", count_divisible_substrings("bdh".to_string())); // 4
    println!("{}", count_divisible_substrings("abcd".to_string())); // 6
}
