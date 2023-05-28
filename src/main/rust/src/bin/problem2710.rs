// https://leetcode.com/problems/remove-trailing-zeros-from-a-string/
pub fn remove_trailing_zeros(num: String) -> String {
    let chars: Vec<char> = num.chars().collect();
    let mut i = num.len() as i32 - 1;
    while i >= 0 {
        if chars[i as usize] != '0' {
            break;
        }
        i -= 1;
    }
    (&chars[0..i as usize + 1]).iter().collect::<String>()
}

fn main() {
    println!("{}", remove_trailing_zeros("51230100".to_string())); // "512301"
    println!("{}", remove_trailing_zeros("123".to_string())); // "123"
}
