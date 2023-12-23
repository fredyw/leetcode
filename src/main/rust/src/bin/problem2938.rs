// https://leetcode.com/problems/separate-black-and-white-balls/description/
pub fn minimum_steps(s: String) -> i64 {
    let mut answer = 0;
    let mut chars: Vec<char> = s.chars().collect();
    let mut j = chars.len() as i32 - 1;
    while j >= 0 && chars[j as usize] == '1' {
        j -= 1;
    }
    let mut i = j - 1;
    while i >= 0 {
        if chars[i as usize] == '1' {
            chars.swap(i as usize, j as usize);
            j -= 1;
            answer += j as i64 - i as i64 + 1;
        }
        i -= 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_steps("101".to_string())); // 1
    println!("{}", minimum_steps("100".to_string())); // 2
    println!("{}", minimum_steps("0111".to_string())); // 0
    println!("{}", minimum_steps("1001001101".to_string())); // 10
}
