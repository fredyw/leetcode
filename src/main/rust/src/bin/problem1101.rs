// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/
pub fn earliest_acq(logs: Vec<Vec<i32>>, n: i32) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        earliest_acq(
            vec![
                vec![20190101, 0, 1],
                vec![20190104, 3, 4],
                vec![20190107, 2, 3],
                vec![20190211, 1, 5],
                vec![20190224, 2, 4],
                vec![20190301, 0, 3],
                vec![20190312, 1, 2],
                vec![20190322, 4, 5]
            ],
            6
        )
    ); // 20190301
    println!(
        "{}",
        earliest_acq(
            vec![
                vec![0, 2, 0],
                vec![1, 0, 1],
                vec![3, 0, 3],
                vec![4, 1, 2],
                vec![7, 3, 1]
            ],
            4
        )
    ); // 3
}
