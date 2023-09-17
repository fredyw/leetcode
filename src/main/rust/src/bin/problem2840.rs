use std::collections::HashMap;

// https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/
pub fn check_strings(s1: String, s2: String) -> bool {
    fn build_maps(s: String) -> (HashMap<u8, i32>, HashMap<u8, i32>) {
        let bytes = s.as_bytes();
        let mut even_map1: HashMap<u8, i32> = HashMap::new();
        let mut i = 0;
        while i < bytes.len() {
            *even_map1.entry(bytes[i]).or_insert(0) += 1;
            i += 2;
        }
        let mut odd_map1: HashMap<u8, i32> = HashMap::new();
        let mut i = 1;
        while i < bytes.len() {
            *odd_map1.entry(bytes[i]).or_insert(0) += 1;
            i += 2;
        }
        (even_map1, odd_map1)
    }

    build_maps(s1) == build_maps(s2)
}

fn main() {
    println!(
        "{}",
        check_strings("abcdba".to_string(), "cabdab".to_string())
    ); // true
    println!("{}", check_strings("abe".to_string(), "bea".to_string())); // false
}
