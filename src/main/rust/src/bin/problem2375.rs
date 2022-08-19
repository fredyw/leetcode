// https://leetcode.com/problems/construct-smallest-number-from-di-string/
pub fn smallest_number(pattern: String) -> String {
    todo!()
}

fn main() {
    println!("{}", smallest_number("IIIDIDDD".to_string())); // "123549876"
    println!("{}", smallest_number("DDD".to_string())); // "4321"
    println!("{}", smallest_number("IDIDIDID".to_string())); // "132547698"
    println!("{}", smallest_number("DIDIDIDI".to_string())); // "214365879"
}
