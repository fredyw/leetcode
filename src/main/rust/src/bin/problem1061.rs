// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
pub fn smallest_equivalent_string(s1: String, s2: String, base_str: String) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        smallest_equivalent_string(
            "parker".to_string(),
            "morris".to_string(),
            "parser".to_string()
        )
    ); // "makkek"
    println!(
        "{}",
        smallest_equivalent_string("hello".to_string(), "world".to_string(), "hold".to_string())
    ); // "hdld"
    println!(
        "{}",
        smallest_equivalent_string(
            "leetcode".to_string(),
            "programs".to_string(),
            "sourcecode".to_string()
        )
    ); // "aauaaaaada"
}
