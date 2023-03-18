// https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/
pub fn minimum_partition(s: String, k: i32) -> i32 {
    let mut answer = 0;
    let chars: Vec<char> = s.chars().collect();
    let mut s = String::new();
    let mut i = 0;
    while i < chars.len() {
        s.push(chars[i]);
        let mut n = s.parse::<i64>().unwrap();
        let mut found = false;
        while n <= k as i64 && i < chars.len() {
            found = true;
            i += 1;
            if i < chars.len() {
                s.push(chars[i]);
                n = s.parse::<i64>().unwrap();
            }
        }
        s.clear();
        if !found {
            return -1;
        }
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_partition("165462".to_string(), 60)); // 4
    println!("{}", minimum_partition("238182".to_string(), 5)); // -1
    println!("{}", minimum_partition("1356".to_string(), 500)); // 2
    println!("{}", minimum_partition("1356".to_string(), 500)); // 2
    println!("{}", minimum_partition("8974735375948735".to_string(), 69)); // 10
}
