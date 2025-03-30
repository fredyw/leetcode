// https://leetcode.com/problems/reverse-degree-of-a-string/description/
pub fn reverse_degree(s: String) -> i32 {
    s.chars()
        .into_iter()
        .enumerate()
        .map(|(i, c)| (i as i32 + 1) * (26 - (c as i32 - 'a' as i32)))
        .sum()
}

fn main() {
    println!("{}", reverse_degree("abc".to_string())); // 148
    println!("{}", reverse_degree("zaza".to_string())); // 160
}
