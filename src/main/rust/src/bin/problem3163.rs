// https://leetcode.com/problems/string-compression-iii/description/
pub fn compressed_string(word: String) -> String {
    let mut answer = String::new();
    let mut count = 0;
    let mut char = ' ';
    for c in word.chars() {
        if c != char {
            if char != ' ' {
                answer.push(char::from_digit(count, 10).unwrap());
                answer.push(char);
            }
            char = c;
            count = 1;
        } else {
            count += 1;
            if count > 9 {
                answer.push('9');
                answer.push(char);
                count = 1;
            }
        }
    }
    answer.push(char::from_digit(count, 10).unwrap());
    answer.push(char);
    answer
}

fn main() {
    println!("{:?}", compressed_string("abcde".to_string())); // "1a1b1c1d1e"
    println!("{:?}", compressed_string("aaaaaaaaaaaaaabb".to_string())); // "9a5a2b"
}
