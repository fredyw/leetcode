use std::collections::HashSet;

fn strong_password_checker_ii(password: String) -> bool {
    if password.len() < 8 {
        return false;
    }
    let mut set = HashSet::new();
    for c in "!@#$%^&*()-+".chars() {
        set.insert(c);
    }
    let mut uppercase_count = 0;
    let mut lowercase_count = 0;
    let mut digit_count = 0;
    let mut special_char_count = 0;
    for c in password.chars() {
        if c >= 'a' && c <= 'z' {
            lowercase_count += 1;
        } else if c >= 'A' && c <= 'Z' {
            uppercase_count += 1;
        } else if c >= '0' && c <= '9' {
            digit_count += 1;
        } else if set.contains(&c) {
            special_char_count += 1;
        }
    }
    let chars: Vec<char> = password.chars().collect();
    for (i, e) in chars.iter().enumerate() {
        if i + 1 == chars.len() {
            break;
        }
        if *e == chars[i + 1] {
            return false;
        }
    }
    uppercase_count > 0 && lowercase_count > 0 && digit_count > 0 && special_char_count > 0
}

fn main() {
    println!(
        "{}",
        strong_password_checker_ii("IloveLe3tcode!".to_string())
    ); // true
    println!(
        "{}",
        strong_password_checker_ii("IloveLeetcode!".to_string())
    ); // false
    println!(
        "{}",
        strong_password_checker_ii("Me+You--IsMyDream".to_string())
    ); // false
    println!("{}", strong_password_checker_ii("1aB!".to_string())); // false
}
