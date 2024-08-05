use std::collections::BTreeMap;

// https://leetcode.com/problems/meeting-rooms-ii/description/
pub fn min_meeting_rooms(intervals: Vec<Vec<i32>>) -> i32 {
    let mut prefix_sum: BTreeMap<i32, i32> = BTreeMap::new();
    for interval in intervals.into_iter() {
        let start = interval[0];
        let end = interval[1];
        *prefix_sum.entry(start).or_insert(0) += 1;
        *prefix_sum.entry(end).or_insert(0) -= 1;
    }
    let mut answer = 0;
    let mut sum = 0;
    for (_, count) in prefix_sum.iter() {
        sum += *count;
        answer = answer.max(sum);
    }
    answer
}

fn main() {
    println!(
        "{}",
        min_meeting_rooms(vec![vec![0, 30], vec![5, 10], vec![15, 20]])
    ); // 2
    println!("{}", min_meeting_rooms(vec![vec![7, 10], vec![2, 4]])); // 1
    println!(
        "{}",
        min_meeting_rooms(vec![vec![9, 10], vec![4, 9], vec![4, 17]])
    ); // 2
    println!(
        "{}",
        min_meeting_rooms(vec![vec![6, 15], vec![13, 20], vec![6, 17]])
    ); // 3
    println!(
        "{}",
        min_meeting_rooms(vec![vec![6, 15], vec![13, 20], vec![6, 17], vec![20, 23]])
    ); // 3
    println!(
        "{}",
        min_meeting_rooms(vec![vec![2, 11], vec![6, 16], vec![11, 16]])
    ); // 2
    println!(
        "{}",
        min_meeting_rooms(vec![vec![2, 11], vec![6, 16], vec![11, 16], vec![13, 14]])
    ); // 3
    println!(
        "{}",
        min_meeting_rooms(vec![vec![1, 5], vec![8, 9], vec![8, 9]])
    ); // 2
    println!("{}", min_meeting_rooms(vec![vec![8, 9], vec![8, 9]])); // 2
    println!(
        "{}",
        min_meeting_rooms(vec![vec![8, 14], vec![12, 13], vec![6, 13], vec![1, 9]])
    ); // 3
}
