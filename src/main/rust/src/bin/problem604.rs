// https://leetcode.com/problems/design-compressed-string-iterator/description/
struct StringIterator {
    chars: Vec<(char, u32)>,
    index: usize,
}

impl StringIterator {
    fn new(compressed_string: String) -> Self {
        let mut chars: Vec<(char, u32)> = vec![];
        let mut char = ' ';
        let mut num = String::new();
        for c in compressed_string.chars() {
            if c.is_numeric() {
                num.push(c);
            } else {
                if !num.is_empty() {
                    chars.push((char, num.parse::<u32>().unwrap()));
                }
                num.clear();
                char = c;
            }
        }
        chars.push((char, num.parse::<u32>().unwrap()));
        StringIterator { chars, index: 0 }
    }

    fn next(&mut self) -> char {
        if let Some((char, count)) = self.chars.get_mut(self.index) {
            *count -= 1;
            if *count == 0 {
                self.index += 1;
            }
            *char
        } else {
            ' '
        }
    }

    fn has_next(&self) -> bool {
        self.index < self.chars.len() && self.chars[self.index].1 > 0
    }
}

fn main() {
    let mut iter = StringIterator::new("L1e2t1C1o1d1e1".to_string());
    println!("{}", iter.next()); // "L"
    println!("{}", iter.next()); // "e"
    println!("{}", iter.next()); // "e"
    println!("{}", iter.next()); // "t"
    println!("{}", iter.next()); // "C"
    println!("{}", iter.next()); // "o"
    println!("{}", iter.has_next()); // true
    println!("{}", iter.next()); // "d"
    println!("{}", iter.has_next()); // true
    println!("{}", iter.next()); // "e"
    println!("{}", iter.has_next()); // false
}
