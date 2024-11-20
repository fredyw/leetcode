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
        if pattern_index == pattern.len() && string_index == string.len() {
            return true;
        }
        let mut found = false;
        for i in pattern_index + 1..=pattern.len() {
            let possible_p = &pattern[pattern_index..pattern_index + 1];
            println!("p[{}] = {}", pattern_index, possible_p);
            for j in string_index + 1..=string.len() {
                let possible_s = &string[string_index..j];
                println!("  - s[{}..{}] = {}", string_index, j, possible_s);
                if let Some(found_s) = pattern_to_string_map.get(possible_p) {
                    if *found_s != possible_s {
                        continue;
                    }
                }
                if let Some(found_p) = string_to_pattern_map.get(possible_s) {
                    if *found_p != possible_p {
                        continue;
                    }
                }
                string_to_pattern_map.insert(possible_s, possible_p);
                pattern_to_string_map.insert(possible_p, possible_s);
                found |= word_pattern_match(
                    pattern,
                    string,
                    i,
                    j,
                    pattern_to_string_map,
                    string_to_pattern_map,
                );
                pattern_to_string_map.remove(possible_p);
                string_to_pattern_map.remove(possible_s);
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
    println!(
        "{}",
        word_pattern_match("aaaa".to_string(), "asdasdasdasd".to_string())
    ); // true
    println!(
        "{}",
        word_pattern_match("aabb".to_string(), "xyzabcxzyabc".to_string())
    ); // false
}
