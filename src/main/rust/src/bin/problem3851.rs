use std::collections::{HashMap, VecDeque};

// https://leetcode.com/problems/maximum-requests-without-violating-the-limit/description/
pub fn max_requests(requests: Vec<Vec<i32>>, k: i32, window: i32) -> i32 {
    let mut map: HashMap<i32, Vec<i32>> = HashMap::new();
    for request in &requests {
        let user = request[0];
        let time = request[1];
        map.entry(user).or_insert_with(Vec::new).push(time);
    }
    for (_, time) in &mut map {
        time.sort_unstable();
    }
    let mut answer = 0;
    for (_, time) in &map {
        let mut deque: VecDeque<i32> = VecDeque::new();
        for t in time {
            while let Some(front) = deque.front() {
                if *front < *t - window {
                    deque.pop_front();
                } else {
                    break;
                }
            }
            if deque.len() < k as usize {
                answer += 1;
                deque.push_back(*t);
            }
        }
    }
    answer
}

fn main() {
    // println!(
    //     "{}",
    //     max_requests(vec![vec![1, 1], vec![2, 1], vec![1, 7], vec![2, 8]], 1, 4)
    // ); // 4
    println!(
        "{}",
        max_requests(vec![vec![1, 2], vec![1, 5], vec![1, 2], vec![1, 6]], 2, 5)
    ); // 2
       // println!(
       //     "{}",
       //     max_requests(vec![vec![1, 1], vec![2, 5], vec![1, 2], vec![3, 9]], 1, 1)
       // ); // 3
       // println!(
       //     "{}",
       //     max_requests(
       //         vec![vec![1, 1], vec![1, 3], vec![1, 5], vec![1, 7], vec![1, 9]],
       //         2,
       //         3
       //     )
       // ); // 5
       // println!(
       //     "{}",
       //     max_requests(
       //         vec![vec![1, 1], vec![1, 2], vec![1, 3], vec![1, 4], vec![1, 5]],
       //         2,
       //         2
       //     )
       // ); // 4
}
