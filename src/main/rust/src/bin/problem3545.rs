// https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/
pub fn min_deletion(s: String, k: i32) -> i32 {
    todo!()
}

fn main() {
    println!("{}", min_deletion("abc".to_string(), 2)); // 1
    println!("{}", min_deletion("aabb".to_string(), 2)); // 0
    println!("{}", min_deletion("yyyzz".to_string(), 1)); // 2
}
