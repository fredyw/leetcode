// https://leetcode.com/problems/make-three-strings-equal/description/
pub fn find_minimum_operations(s1: String, s2: String, s3: String) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        find_minimum_operations("abc".to_string(), "abb".to_string(), "ab".to_string())
    ); // 2
    println!(
        "{}",
        find_minimum_operations("dac".to_string(), "bac".to_string(), "cac".to_string())
    ); // -1
}
