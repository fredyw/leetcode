// https://leetcode.com/problems/generalized-abbreviation/
pub fn generate_abbreviations(word: String) -> Vec<String> {
    fn generate_abbreviations(
        chars: &Vec<char>,
        index: usize,
        count: u32,
        can_use_number: bool,
        abbr: &mut Vec<char>,
    ) {
        let s1: String = abbr.iter().collect();
        let s2: String = if index == chars.len() {
            "".to_string()
        } else {
            (&chars[index..]).iter().collect()
        };
        println!("{}{}", s1, s2);
        if index == chars.len() {
            return;
        }
        if can_use_number {
            abbr.push(char::from_digit(count, 10).unwrap());
            generate_abbreviations(chars, index + 1, 1, false, abbr);
            abbr.pop();

            generate_abbreviations(chars, index + 1, count + 1, true, abbr);
        } else {
            abbr.push(chars[index]);
            generate_abbreviations(chars, index + 1, 1, true, abbr);
            abbr.pop();
        }
    }

    let chars: Vec<char> = word.chars().collect();
    generate_abbreviations(&chars, 0, 1, false, &mut vec![]);
    generate_abbreviations(&chars, 0, 1, true, &mut vec![]);
    vec![]
}

fn main() {
    println!("{:?}", generate_abbreviations("word".to_string())); // ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]
                                                                  // println!("{:?}", generate_abbreviations("a".to_string())); // ["1","a"]
}
