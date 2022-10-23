// https://leetcode.com/problems/determine-if-two-events-have-conflict/
pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
    fn to_minutes(time: String) -> i32 {
        let mut split = time.split(":");
        let hours: i32 = split.next().unwrap().parse().unwrap();
        let minutes: i32 = split.next().unwrap().parse().unwrap();
        (hours * 60) + minutes
    }

    let from_event1 = to_minutes(event1[0].to_string());
    let to_event1 = to_minutes(event1[1].to_string());
    let from_event2 = to_minutes(event2[0].to_string());
    let to_event2 = to_minutes(event2[1].to_string());

    from_event1 <= from_event2 && from_event2 <= to_event1
        || from_event2 <= from_event1 && from_event1 <= to_event2
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
            vec!["02:00".to_string(), "03:00".to_string()],
            vec!["01:15".to_string(), "02:00".to_string()]
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
