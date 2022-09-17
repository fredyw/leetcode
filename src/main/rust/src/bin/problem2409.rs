// https://leetcode.com/problems/count-days-spent-together/
pub fn count_days_together(
    arrive_alice: String,
    leave_alice: String,
    arrive_bob: String,
    leave_bob: String,
) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        count_days_together(
            "08-15".to_string(),
            "08-18".to_string(),
            "08-16".to_string(),
            "08-19".to_string()
        )
    ); // 3
    println!(
        "{}",
        count_days_together(
            "10-01".to_string(),
            "10-31".to_string(),
            "11-01".to_string(),
            "12-31".to_string()
        )
    ); // 0
}
