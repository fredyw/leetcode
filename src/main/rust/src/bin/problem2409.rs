extern crate core;

// https://leetcode.com/problems/count-days-spent-together/
pub fn count_days_together(
    arrive_alice: String,
    leave_alice: String,
    arrive_bob: String,
    leave_bob: String,
) -> i32 {
    const NUM_DAYS: [i32; 12] = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

    fn to_days(date: String) -> i32 {
        let v: Vec<&str> = date.split("-").collect();
        let month: i32 = v[0].parse().unwrap();
        let day: i32 = v[1].parse().unwrap();
        let mut days = day;
        for i in 0..month - 1 {
            days += NUM_DAYS[i as usize];
        }
        days
    }
    let mut answer = 0;
    let arrive_alice_days = to_days(arrive_alice);
    let leave_alice_days = to_days(leave_alice);
    let arrive_bob_days = to_days(arrive_bob);
    let leave_bob_days = to_days(leave_bob);
    if (arrive_alice_days <= arrive_bob_days && arrive_bob_days <= leave_alice_days)
        || (arrive_bob_days <= arrive_alice_days && arrive_alice_days <= leave_bob_days)
    {
        answer += leave_alice_days.min(leave_bob_days) - arrive_alice_days.max(arrive_bob_days) + 1;
    }
    answer
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
            "08-15".to_string(),
            "08-18".to_string(),
            "08-18".to_string(),
            "08-19".to_string()
        )
    ); // 1
    println!(
        "{}",
        count_days_together(
            "08-15".to_string(),
            "11-18".to_string(),
            "07-19".to_string(),
            "12-19".to_string()
        )
    ); // 96
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
