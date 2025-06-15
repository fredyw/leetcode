use std::collections::HashMap;

// https://leetcode.com/problems/count-odd-letters-from-number/description/
pub fn count_odd_letters(n: i32) -> i32 {
    fn str(n: char) -> &'static str {
        match n {
            '0' => "zero",
            '1' => "one",
            '2' => "two",
            '3' => "three",
            '4' => "four",
            '5' => "five",
            '6' => "six",
            '7' => "seven",
            '8' => "eight",
            '9' => "nine",
            _ => panic!(),
        }
    }

    let mut string = String::new();
    for c in n.to_string().chars() {
        string.push_str(str(c));
    }
    let mut answer: HashMap<char, i32> = HashMap::new();
    for c in string.chars().into_iter() {
        *answer.entry(c).or_insert(0) += 1;
    }
    answer
        .values()
        .into_iter()
        .filter_map(|&count| if count % 2 != 0 { Some(count) } else { None })
        .count() as i32
}

fn main() {
    println!("{}", count_odd_letters(41)); // 5
    println!("{}", count_odd_letters(20)); // 5
    println!("{}", count_odd_letters(1000000000)); // 3
}
