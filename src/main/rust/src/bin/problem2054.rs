use std::cmp;

// https://leetcode.com/problems/two-best-non-overlapping-events/
pub fn max_two_events(events: Vec<Vec<i32>>) -> i32 {
    let mut events = events.clone();
    events.sort_by(|a, b| {
        let start_time1 = &a[0];
        let end_time1 = &a[1];
        let start_time2 = &b[0];
        let end_time2 = &b[1];
        let o = start_time1.cmp(start_time2);
        if o.is_eq() {
            end_time1.cmp(end_time2)
        } else {
            o
        }
    });
    let mut answer = 0;
    for i in 0..events.len() {
        let end_time1 = &events[i][1];
        let value1 = &events[i][2];
        answer = cmp::max(answer, *value1);
        for j in (i + 1)..events.len() {
            let start_time2 = &events[j][0];
            let value2 = &events[j][2];
            if end_time1 < start_time2 {
                answer = cmp::max(answer, value1 + value2);
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        max_two_events(vec![vec![1, 3, 2], vec![4, 5, 2], vec![2, 4, 3]])
    ); // 4
    println!(
        "{}",
        max_two_events(vec![vec![1, 3, 2], vec![4, 5, 2], vec![1, 5, 5]])
    ); // 5
    println!(
        "{}",
        max_two_events(vec![vec![1, 5, 3], vec![1, 5, 1], vec![6, 6, 5]])
    ); // 8
    println!(
        "{}",
        max_two_events(vec![
            vec![10, 83, 53],
            vec![63, 87, 45],
            vec![97, 100, 32],
            vec![51, 61, 16]
        ])
    ); // 85
}
