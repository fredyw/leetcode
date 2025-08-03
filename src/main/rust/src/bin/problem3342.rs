// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/
pub fn min_time_to_reach(move_time: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", min_time_to_reach(vec![vec![0, 4], vec![4, 4]])); // 7
    println!(
        "{}",
        min_time_to_reach(vec![vec![0, 0, 0, 0], vec![0, 0, 0, 0]])
    ); // 6
    println!("{}", min_time_to_reach(vec![vec![0, 1], vec![1, 2]])); // 4
}
