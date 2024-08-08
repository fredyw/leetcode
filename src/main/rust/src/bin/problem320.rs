// https://leetcode.com/problems/generalized-abbreviation/
pub fn generate_abbreviations(word: String) -> Vec<String> {
    fn generate_abbreviations(
        chars: &Vec<char>,
        index: usize,
        count: i32,
        is_number: bool,
        abbr: &mut Vec<char>,
    ) {
        if index == chars.len() {
            return;
        }
        if is_number {
            generate_abbreviations(chars, index + 1, 0, false, abbr);
        } else {
            generate_abbreviations(chars, index + 1, 0, true, abbr);
            generate_abbreviations(chars, index + 1, count + 1, false, abbr);
        }
    }

    todo!()
}

fn main() {
    println!("{:?}", generate_abbreviations("word".to_string())); // ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]
    println!("{:?}", generate_abbreviations("a".to_string())); // ["1","a"]
}
