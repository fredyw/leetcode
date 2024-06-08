// https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/
pub fn minimum_chairs(s: String) -> i32 {
    let mut answer = 0;
    let mut num_chair = 0;
    for char in s.chars() {
        if char == 'E' {
            num_chair += 1;
        } else {
            num_chair -= 1;
        }
        answer = answer.max(num_chair);
    }
    answer
}

fn main() {
    println!("{}", minimum_chairs("EEEEEEE".to_string())); // 7
    println!("{}", minimum_chairs("ELELEEL".to_string())); // 2
    println!("{}", minimum_chairs("ELEELEELLL".to_string())); // 3
}
