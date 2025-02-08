use std::collections::HashSet;

// https://leetcode.com/problems/number-of-distinct-binary-strings-after-applying-operations/description/
pub fn count_distinct_strings(s: String, k: i32) -> i32 {
    fn flip(chars: &mut Vec<char>, i: usize, k: i32) {
        for j in i..i + k as usize {
            chars[j] = if chars[j] == '1' { '0' } else { '1' };
        }
    }

    fn count_distinct_strings(chars: &mut Vec<char>, k: i32, set: &mut HashSet<Vec<char>>) {
        let mut i = 0;
        while (i + k as usize) < chars.len() {
            if set.contains(chars) {
                flip(chars, i, k);
                i += 1;
                continue;
            }
            set.insert(chars.clone());
            flip(chars, i, k);
            count_distinct_strings(chars, k, set);
            flip(chars, i, k);
            i += 1;
        }
    }
    let mut chars: Vec<char> = s.chars().collect();
    let mut set: HashSet<Vec<char>> = HashSet::new();
    count_distinct_strings(&mut chars, k, &mut set);
    println!("{:?}", set);
    set.len() as i32
}

fn main() {
    println!("{}", count_distinct_strings("1001".to_string(), 3)); // 4
                                                                   // println!("{}", count_distinct_strings("10110".to_string(), 5)); // 2
                                                                   // println!("{}", count_distinct_strings("1001".to_string(), 2)); // 8
}
