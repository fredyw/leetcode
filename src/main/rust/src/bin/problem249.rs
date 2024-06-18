// https://leetcode.com/problems/group-shifted-strings/description/
pub fn group_strings(strings: Vec<String>) -> Vec<Vec<String>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        group_strings(vec![
            "abc".to_string(),
            "bcd".to_string(),
            "acef".to_string(),
            "xyz".to_string(),
            "az".to_string(),
            "ba".to_string(),
            "a".to_string(),
            "z".to_string()
        ])
    ); // [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
    println!("{:?}", group_strings(vec!["a".to_string(),])); // [["a"]]
}
