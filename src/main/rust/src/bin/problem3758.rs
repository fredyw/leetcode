// https://leetcode.com/problems/convert-number-words-to-digits/description/
pub fn convert_number(s: String) -> String {
    fn is_number(s: &str, i: usize) -> (char, usize) {
        for (num_str, num_char) in [
            ("zero".to_string(), '0'),
            ("one".to_string(), '1'),
            ("two".to_string(), '2'),
            ("three".to_string(), '3'),
            ("four".to_string(), '4'),
            ("five".to_string(), '5'),
            ("six".to_string(), '6'),
            ("seven".to_string(), '7'),
            ("eight".to_string(), '8'),
            ("nine".to_string(), '9'),
        ]
        .iter()
        {
            if i + num_str.len() <= s.len() {
                let sub = &s[i..i + num_str.len()];
                if sub == num_str {
                    return (*num_char, i + num_str.len());
                }
            }
        }
        (' ', i + 1)
    }

    let mut answer = String::new();
    let mut i = 0;
    while i < s.len() {
        let (num, index) = is_number(&s, i);
        if num != ' ' {
            answer.push(num);
            i = index;
        } else {
            i = index;
        }
    }
    answer
}

fn main() {
    println!("{}", convert_number("onefourthree".to_string())); // "43"
    println!("{}", convert_number("ninexsix".to_string())); // "96"
    println!("{}", convert_number("zeero".to_string())); // "
    println!("{}", convert_number("tw".to_string())); // ""
    println!("{}", convert_number("oneforthree".to_string())); // "13"
}
