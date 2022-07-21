// https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
pub fn earliest_full_bloom(plant_time: Vec<i32>, grow_time: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", earliest_full_bloom(vec![1, 4, 3], vec![2, 3, 1])); // 9
    println!(
        "{}",
        earliest_full_bloom(vec![1, 2, 3, 2], vec![2, 1, 2, 1])
    ); // 9
    println!("{}", earliest_full_bloom(vec![1], vec![1])); // 2
}
