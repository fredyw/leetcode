// https://leetcode.com/problems/faulty-keyboard/
pub fn final_string(s: String) -> String {
    let mut answer: Vec<char> = vec![];
    let chars: Vec<char> = s.chars().collect();
    let mut i = 0;
    while i < chars.len() {
        if chars[i] == 'i' {
            let mut count = 0;
            let mut j = i;
            while j < chars.len() && chars[j] == 'i' {
                count += 1;
                j += 1;
            }
            if count % 2 != 0 {
                answer.reverse();
            }
            i = j;
        } else {
            answer.push(chars[i]);
            i += 1;
        }
    }
    answer.into_iter().collect()
}

fn main() {
    println!("{}", final_string("string".to_string())); // "rtsng"
    println!("{}", final_string("poiinter".to_string())); // "ponter"
    println!("{}", final_string("abcdef".to_string())); // "abcdef"
    println!("{}", final_string("viwif".to_string())); // "wvf"
}
