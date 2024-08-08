// https://leetcode.com/problems/generalized-abbreviation/
pub fn generate_abbreviations(word: String) -> Vec<String> {
    fn generate_abbreviations(
        chars: &Vec<char>,
        index: usize,
        count: u32,
        length: u32,
        can_use_number: bool,
        abbr: &mut Vec<char>,
        answer: &mut Vec<String>,
    ) {
        if index == chars.len() {
            if length != chars.len() as u32 {
                return;
            }
            let mut s: String = abbr.iter().collect();
            if can_use_number && count - 1 > 0 {
                s.push_str(&(count - 1).to_string());
            }
            answer.push(s);
            return;
        }
        if can_use_number {
            generate_abbreviations(chars, index + 1, count + 1, length, true, abbr, answer);

            for c in count.to_string().chars() {
                abbr.push(c);
            }
            generate_abbreviations(chars, index + 1, 1, length + count, false, abbr, answer);
            for _ in 0..count.to_string().len() {
                abbr.pop();
            }

            abbr.push(chars[index]);
            generate_abbreviations(chars, index + 1, 1, length + 1, true, abbr, answer);
            abbr.pop();
        } else {
            abbr.push(chars[index]);
            generate_abbreviations(chars, index + 1, 1, length + 1, true, abbr, answer);
            abbr.pop();
        }
    }

    let mut answer: Vec<String> = vec![];
    let chars: Vec<char> = word.chars().collect();
    generate_abbreviations(&chars, 0, 1, 0, true, &mut vec![], &mut answer);
    answer
}

fn main() {
    println!("{:?}", generate_abbreviations("word".to_string())); // ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]
    println!("{:?}", generate_abbreviations("a".to_string())); // ["1","a"]
}
