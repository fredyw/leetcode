// https://leetcode.com/problems/meeting-rooms-ii/description/
pub fn min_meeting_rooms(intervals: Vec<Vec<i32>>) -> i32 {
    let mut intervals: Vec<(i32, i32)> = intervals.into_iter().map(|v| (v[0], v[1])).collect();
    intervals.sort();
    todo!()
}

fn main() {
    println!(
        "{}",
        min_meeting_rooms(vec![vec![0, 30], vec![5, 10], vec![15, 20]])
    ); // 2
    println!("{}", min_meeting_rooms(vec![vec![7, 10], vec![2, 4]])); // 1
}
