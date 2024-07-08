// https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/
pub fn valid_strings(n: i32) -> Vec<String> {
    fn valid_strings(n: usize, chars: &mut Vec<char>, zero: bool, strings: &mut Vec<String>) {
        if chars.len() == n {
            strings.push(chars.iter().collect());
            return;
        }
        if zero {
            chars.push('1');
            valid_strings(n, chars, false, strings);
            chars.pop();
        } else {
            chars.push('0');
            valid_strings(n, chars, true, strings);
            chars.pop();
            chars.push('1');
            valid_strings(n, chars, false, strings);
            chars.pop();
        }
    }

    let mut answer: Vec<String> = vec![];
    valid_strings(n as usize, &mut vec![], false, &mut answer);
    answer
}

fn main() {
    println!("{:?}", valid_strings(3)); // ["010","011","101","110","111"]
    println!("{:?}", valid_strings(1)); // ["0","1"]
}
