// https://leetcode.com/problems/reverse-words-with-same-vowel-count/description/
pub fn reverse_words(s: String) -> String {
    fn count_vowel(s: &str) -> usize {
        s.bytes()
            .filter(|c| *c == b'a' || *c == b'e' || *c == b'i' || *c == b'o' || *c == b'u')
            .count()
    }

    let mut answer: Vec<String> = vec![];
    let mut first_vowel_count = 0;
    for (i, split) in s.split(' ').enumerate() {
        let vowel_count = count_vowel(split);
        if i == 0 {
            first_vowel_count = vowel_count;
            answer.push(split.to_string());
        } else {
            if vowel_count == first_vowel_count {
                answer.push(split.chars().rev().collect::<String>());
            } else {
                answer.push(split.to_string());
            }
        }
    }
    answer.join(" ")
}

fn main() {
    println!("{}", reverse_words("cat and mice".to_string())); // "cat dna mice"
    println!("{}", reverse_words("book is nice".to_string())); // "book is ecin"
    println!("{}", reverse_words("banana healthy".to_string())); // "banana healthy"
    println!("{}", reverse_words("one sky".to_string())); // "one sky"
    println!("{}", reverse_words("xxx xyz".to_string())); // "one sky"
}
