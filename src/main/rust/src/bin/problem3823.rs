// https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/
pub fn reverse_by_type(s: String) -> String {
    todo!()
}

fn main() {
    println!("{}", reverse_by_type(")ebc#da@f(".to_string())); // "(fad@cb#e)"
    println!("{}", reverse_by_type("z".to_string())); // "z"
    println!("{}", reverse_by_type("!@#$%^&*()".to_string())); // ")(*&^%$#@!"
}
