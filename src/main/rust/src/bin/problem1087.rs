// https://leetcode.com/problems/brace-expansion/description/
pub fn expand(s: String) -> Vec<String> {
    fn expand(
        chars: &Vec<char>,
        mut i: usize,
        expanded_chars: &mut Vec<char>,
        strings: &mut Vec<String>,
    ) {
        if i == chars.len() {
            strings.push(expanded_chars.iter().collect());
            return;
        }
        if chars[i] == '{' {
            i += 1;
            let mut options: Vec<char> = vec![];
            while i < chars.len() && chars[i] != '}' {
                if chars[i] != ',' {
                    options.push(chars[i]);
                }
                i += 1;
            }
            for c in options.iter() {
                expanded_chars.push(*c);
                expand(chars, i + 1, expanded_chars, strings);
                expanded_chars.pop();
            }
        } else {
            expanded_chars.push(chars[i]);
            expand(chars, i + 1, expanded_chars, strings);
            expanded_chars.pop();
        }
    }

    let mut answer: Vec<String> = vec![];
    let chars: Vec<char> = s.chars().collect();
    expand(&chars, 0, &mut vec![], &mut answer);
    answer.sort();
    answer
}

fn main() {
    println!("{:?}", expand("{a,b}c{d,e}f".to_string())); // ["acdf","acef","bcdf","bcef"]
    println!("{:?}", expand("abcd".to_string())); // ["abcd"]
    println!("{:?}", expand("{a,b}{z,x,y}".to_string())); // ["ax","ay","az","bx","by","bz"]
}
