// https://leetcode.com/problems/brace-expansion/description/
pub fn expand(s: String) -> Vec<String> {
    todo!()
}

fn main() {
    println!("{:?}", expand("{a,b}c{d,e}f".to_string())); // ["acdf","acef","bcdf","bcef"]
    println!("{:?}", expand("abcd".to_string())); // ["acdf","acef","bcdf","bcef"]
}
