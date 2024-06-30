// https://leetcode.com/problems/meeting-rooms/description/
pub fn can_attend_meetings(intervals: Vec<Vec<i32>>) -> bool {
    if intervals.is_empty() {
        return true;
    }
    let mut intervals: Vec<(i32, i32)> = intervals.into_iter().map(|v| (v[0], v[1])).collect();
    intervals.sort();
    for i in 0..intervals.len() - 1 {
        if intervals[i].1 > intervals[i + 1].0 {
            return false;
        }
    }
    true
}

fn main() {
    println!(
        "{}",
        can_attend_meetings(vec![vec![0, 30], vec![5, 10], vec![15, 20]])
    ); // false
    println!("{}", can_attend_meetings(vec![vec![7, 10], vec![2, 4]])); // true
    println!("{}", can_attend_meetings(vec![vec![4, 10], vec![2, 4]])); // true
    println!("{}", can_attend_meetings(vec![])); // true
}
