use std::cmp;

// https://leetcode.com/problems/two-best-non-overlapping-events/
pub fn max_two_events(events: Vec<Vec<i32>>) -> i32 {
    fn f(events: &Vec<Vec<i32>>, index: usize, memo: &mut Vec<i32>) -> i32 {
        if index == events.len() {
            return 0;
        }
        if memo[index] != -1 {
            return memo[index];
        }
        let mut max = 0;
        let current_end_time = events[index][1];
        for i in (index + 1)..events.len() {
            let start_time = &events[i][0];
            let value = &events[i][2];
            if current_end_time < *start_time {
                max = cmp::max(max, f(events, i, memo) + value);
            }
        }
        memo[index] = max;
        max
    }

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
    let mut memo = vec![-1; events.len()];
    for i in 0..events.len() {
        let value = &events[i][2];
        answer = cmp::max(answer, f(&events, i, &mut memo) + value);
    }
    answer
}

fn main() {
    // println!(
    //     "{}",
    //     max_two_events(vec![vec![1, 3, 2], vec![4, 5, 2], vec![2, 4, 3]])
    // ); // 4
    // println!(
    //     "{}",
    //     max_two_events(vec![vec![1, 3, 2], vec![4, 5, 2], vec![1, 5, 5]])
    // ); // 5
    // println!(
    //     "{}",
    //     max_two_events(vec![vec![1, 5, 3], vec![1, 5, 1], vec![6, 6, 5]])
    // ); // 8
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
