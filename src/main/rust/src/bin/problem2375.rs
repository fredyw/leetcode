// https://leetcode.com/problems/construct-smallest-number-from-di-string/
pub fn smallest_number(pattern: String) -> String {
    let mut answer = "".to_string();
    let chars: Vec<char> = pattern.chars().into_iter().collect();
    let mut current = 1;
    let mut i = 0;
    while i < chars.len() {
        let mut count = 0;
        while i < chars.len() && chars[i] == 'I' {
            count += 1;
            i += 1;
        }
        for n in current..current + count {
            if let Some(c) = char::from_digit(n, 10) {
                answer.push(c);
            }
        }
        current += count;
        let mut count = 0;
        while i < chars.len() && chars[i] == 'D' {
            count += 1;
            i += 1;
        }
        for n in (current..=current + count).rev() {
            if let Some(c) = char::from_digit(n, 10) {
                answer.push(c);
            }
        }
        current += count + 1;
        i += 1;
    }
    if answer.len() < pattern.len() + 1 {
        if let Some(c) = char::from_digit(current, 10) {
            answer.push(c);
        }
    }
    answer
}

fn main() {
    println!("{}", smallest_number("IIIDIDDD".to_string())); // "123549876"
    println!("{}", smallest_number("DDD".to_string())); // "4321"
    println!("{}", smallest_number("IDIDIDID".to_string())); // "132547698"
    println!("{}", smallest_number("DIDIDIDI".to_string())); // "214365879"
    println!("{}", smallest_number("IDIIDDII".to_string())); // "132476589"
    println!("{}", smallest_number("IIIDDDII".to_string())); // "123765489"
    println!("{}", smallest_number("DDDIIIDD".to_string())); // "432156987"
    println!("{}", smallest_number("IIIIIIII".to_string())); // "123456789"
    println!("{}", smallest_number("DDDDDDDD".to_string())); // "987654321"
    println!("{}", smallest_number("IDI".to_string())); // "1324"
    println!("{}", smallest_number("DID".to_string())); // "2143"
    println!("{}", smallest_number("IIIDD".to_string())); // "123654"
    println!("{}", smallest_number("DDDII".to_string())); // "432156"
}
