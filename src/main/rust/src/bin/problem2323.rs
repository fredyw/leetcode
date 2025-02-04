// https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs-ii/description/
pub fn minimum_time(mut jobs: Vec<i32>, mut workers: Vec<i32>) -> i32 {
    jobs.sort();
    workers.sort();
    let mut answer = 0;
    for i in 0..jobs.len() {
        let num_days = (jobs[i] / workers[i]) + if jobs[i] % workers[i] == 0 { 0 } else { 1 };
        answer = answer.max(num_days);
    }
    answer
}

fn main() {
    println!("{}", minimum_time(vec![5, 2, 4], vec![1, 7, 5])); // 2
    println!("{}", minimum_time(vec![3, 18, 15, 9], vec![6, 5, 1, 3])); // 3
}
