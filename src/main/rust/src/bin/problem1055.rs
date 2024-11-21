// https://leetcode.com/problems/shortest-way-to-form-string/description/
pub fn shortest_way(source: String, target: String) -> i32 {
    todo!()
}

fn main() {
    println!("{}", shortest_way("abc".to_string(), "abcbc".to_string())); // 2
    println!("{}", shortest_way("abc".to_string(), "acdbc".to_string())); // -1
    println!("{}", shortest_way("xyz".to_string(), "xzyxz".to_string())); // 3
}
