// https://leetcode.com/problems/button-with-longest-push-time/description/
pub fn button_with_longest_time(events: Vec<Vec<i32>>) -> i32 {
    let mut max_index = 0;
    let mut max_time = 0;
    for (i, e) in events.iter().enumerate() {
        let index = e[0];
        let time = if i == 0 {
            e[1]
        } else {
            e[1] - events[i - 1][1]
        };
        if max_time < time {
            max_time = time;
            max_index = index;
        } else if max_time == time {
            max_index = max_index.min(index);
        }
    }
    max_index
}

fn main() {
    println!(
        "{}",
        button_with_longest_time(vec![vec![1, 2], vec![2, 5], vec![3, 9], vec![1, 15]])
    ); // 1
    println!(
        "{}",
        button_with_longest_time(vec![vec![10, 5], vec![1, 7]])
    ); // 10
    println!(
        "{}",
        button_with_longest_time(vec![
            vec![9, 4],
            vec![19, 5],
            vec![2, 8],
            vec![3, 11],
            vec![2, 15]
        ])
    ); // 2
}
