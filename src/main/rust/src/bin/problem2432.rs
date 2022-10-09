// https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/
pub fn hardest_worker(n: i32, logs: Vec<Vec<i32>>) -> i32 {
    let mut answer = 0;
    let mut max_time = 0;
    for (i, v) in logs.iter().enumerate() {
        if i == 0 {
            answer = v[0];
            max_time = v[1];
        } else {
            let time = v[1] - logs[i - 1][1];
            if max_time < time {
                answer = v[0];
                max_time = time;
            } else if max_time == time {
                answer = answer.min(v[0]);
                max_time = time;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        hardest_worker(10, vec![vec![0, 3], vec![2, 5], vec![0, 9], vec![1, 15]])
    ); // 1
    println!(
        "{}",
        hardest_worker(26, vec![vec![1, 1], vec![3, 7], vec![2, 12], vec![7, 17]])
    ); // 3
    println!("{}", hardest_worker(2, vec![vec![0, 10], vec![1, 20]])); // 0
}
