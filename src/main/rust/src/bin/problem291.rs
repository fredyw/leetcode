use std::collections::HashMap;

// https://leetcode.com/problems/word-pattern-ii/description/
pub fn word_pattern_match(pattern: String, s: String) -> bool {
    fn word_pattern_match<'a>(
        pattern: &'a str,
        string: &'a str,
        pattern_index: usize,
        string_index: usize,
        pattern_to_string_map: &mut HashMap<&'a str, &'a str>,
        string_to_pattern_map: &mut HashMap<&'a str, &'a str>,
    ) -> bool {
        if pattern_index == pattern.len() {
            return true;
        }
        let mut found = false;
        for i in pattern_index + 1..=pattern.len() {
            let p1 = &pattern[pattern_index..pattern_index + 1];
            for j in string_index + 1..=string.len() {
                let s2 = &string[string_index..j];
                if let Some(s1) = pattern_to_string_map.get(p1) {
                    if *s1 != s2 {
                        continue;
                    }
                }
                if let Some(p2) = string_to_pattern_map.get(s2) {
                    if p1 != *p2 {
                        continue;
                    }
                }
                string_to_pattern_map.insert(s2, p1);
                pattern_to_string_map.insert(p1, s2);
                found |= word_pattern_match(
                    pattern,
                    string,
                    i,
                    j,
                    pattern_to_string_map,
                    string_to_pattern_map,
                );
                pattern_to_string_map.remove(p1);
                string_to_pattern_map.insert(s2, p1);
            }
        }
        found
    }

    word_pattern_match(&pattern, &s, 0, 0, &mut HashMap::new(), &mut HashMap::new())
}

fn main() {
    println!(
        "{}",
        word_pattern_match("abab".to_string(), "redblueredblue".to_string())
    ); // true
       // println!(
       //     "{}",
       //     word_pattern_match("aaaa".to_string(), "asdasdasdasd".to_string())
       // ); // true
       // println!(
       //     "{}",
       //     word_pattern_match("aabb".to_string(), "xyzabcxzyabc".to_string())
       // ); // false
}
