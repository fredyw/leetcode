// https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/
pub fn minimum_partition(s: String, k: i32) -> i32 {
    0
}

fn main() {
    println!("{}", minimum_partition("165462".to_string(), 60)); // 4
    println!("{}", minimum_partition("238182".to_string(), 5)); // -1
    println!("{}", minimum_partition("1356".to_string(), 500)); // 2
    println!("{}", minimum_partition("1356".to_string(), 500)); // 2
    println!("{}", minimum_partition("8974735375948735".to_string(), 69)); // 10
}
