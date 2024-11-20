use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/word-pattern-ii/description/
pub fn word_pattern_match(pattern: String, s: String) -> bool {
    fn word_pattern_match<'a>(
        pattern: &'a str,
        string: &'a str,
        pattern_index: usize,
        string_index: usize,
        pattern_to_string_map: &mut HashMap<&'a str, &'a str>,
        string_set: &mut HashSet<&'a str>,
    ) -> bool {
        if pattern_index == pattern.len() && string_index == string.len() {
            return true;
        }
        if pattern_index >= pattern.len() || string_index >= string.len() {
            return false;
        }
        let possible_p = &pattern[pattern_index..pattern_index + 1];
        if let Some(found_s) = pattern_to_string_map.get(possible_p) {
            if string_index + found_s.len() > string.len() {
                return false;
            }
            let possible_s = &string[string_index..string_index + found_s.len()];
            if possible_s != *found_s {
                return false;
            }
            return word_pattern_match(
                pattern,
                string,
                pattern_index + 1,
                string_index + found_s.len(),
                pattern_to_string_map,
                string_set,
            );
        }
        let mut found = false;
        for i in string_index..string.len() {
            let possible_s = &string[string_index..i + 1];
            if string_set.contains(possible_s) {
                continue;
            }
            pattern_to_string_map.insert(possible_p, possible_s);
            string_set.insert(possible_s);
            found |= word_pattern_match(
                pattern,
                string,
                pattern_index + 1,
                i + 1,
                pattern_to_string_map,
                string_set,
            );
            string_set.remove(possible_s);
            pattern_to_string_map.remove(possible_p);
        }
        found
    }

    word_pattern_match(&pattern, &s, 0, 0, &mut HashMap::new(), &mut HashSet::new())
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
    println!(
        "{}",
        word_pattern_match("ab".to_string(), "abc".to_string())
    ); // true
    println!(
        "{}",
        word_pattern_match("abb".to_string(), "abc".to_string())
    ); // false
    println!(
        "{}",
        word_pattern_match("sucks".to_string(), "teezmmmmteez".to_string())
    ); // false
}
