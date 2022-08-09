use std::collections::HashMap;

// https://leetcode.com/problems/task-scheduler-ii/
pub fn task_scheduler_ii(tasks: Vec<i32>, space: i32) -> i64 {
    let mut answer: i64 = 0;
    let mut map: HashMap<i32, i64> = HashMap::new();
    for task in tasks.into_iter() {
        if let Some(day) = map.get(&task) {
            if *day > answer {
                answer = *day;
            }
        }
        answer += 1;
        map.insert(task, answer + space as i64);
    }
    answer
}

fn main() {
    println!("{}", task_scheduler_ii(vec![1, 2, 1, 2, 3, 1], 3)); // 9
    println!("{}", task_scheduler_ii(vec![5, 8, 8, 5], 2)); // 6
    println!("{}", task_scheduler_ii(vec![1, 2, 3], 3)); // 3
}
