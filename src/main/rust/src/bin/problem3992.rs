// https://leetcode.com/problems/rearrange-string-to-avoid-character-pair/description/
pub fn rearrange_string(s: String, x: char, y: char) -> String {
    todo!()
}

fn main() {
    println!("{}", rearrange_string("aabc".to_string(), 'a', 'c')); // "cbaa"
    println!("{}", rearrange_string("dcab".to_string(), 'd', 'b')); // "cabd"
    println!("{}", rearrange_string("axe".to_string(), 'o', 'x')); // "axe"
}
