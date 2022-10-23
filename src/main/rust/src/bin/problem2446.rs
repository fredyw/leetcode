// https://leetcode.com/problems/determine-if-two-events-have-conflict/
pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        have_conflict(
            vec!["01:15".to_string(), "02:00".to_string()],
            vec!["02:00".to_string(), "03:00".to_string()]
        )
    ); // true
    println!(
        "{}",
        have_conflict(
            vec!["01:00".to_string(), "02:00".to_string()],
            vec!["01:20".to_string(), "03:00".to_string()]
        )
    ); // true
    println!(
        "{}",
        have_conflict(
            vec!["10:00".to_string(), "11:00".to_string()],
            vec!["14:00".to_string(), "15:00".to_string()]
        )
    ); // false
}
