// https://leetcode.com/problems/shortest-way-to-form-string/description/
pub fn shortest_way(source: String, target: String) -> i32 {
    let source: Vec<char> = source.chars().collect();
    let target: Vec<char> = target.chars().collect();
    let mut answer = 0;
    let mut target_idx = 0;
    while target_idx < target.len() {
        let mut found = false;
        let mut source_idx = 0;
        while source_idx < source.len() && target_idx < target.len() {
            if source[source_idx] == target[target_idx] {
                found = true;
                target_idx += 1;
            }
            source_idx += 1;
        }
        if !found {
            return -1;
        }
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", shortest_way("abc".to_string(), "abcbc".to_string())); // 2
    println!("{}", shortest_way("abc".to_string(), "acdbc".to_string())); // -1
    println!("{}", shortest_way("xyz".to_string(), "xzyxz".to_string())); // 3
    println!(
        "{}",
        shortest_way("aaaaa".to_string(), "aaaaaaaaaaaaa".to_string())
    ); // 3
}
