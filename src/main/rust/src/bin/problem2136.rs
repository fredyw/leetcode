// https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
pub fn earliest_full_bloom(plant_time: Vec<i32>, grow_time: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut v: Vec<(i32, i32)> = vec![];
    for i in 0..plant_time.len() {
        v.push((grow_time[i], plant_time[i]));
    }
    v.sort_by(|a, b| b.cmp(a));
    let mut day = 0;
    for (grow, plant) in v.iter() {
        day += plant;
        answer = answer.max(day + grow);
    }
    answer
}

fn main() {
    println!("{}", earliest_full_bloom(vec![1, 4, 3], vec![2, 3, 1])); // 9
    println!(
        "{}",
        earliest_full_bloom(vec![1, 2, 3, 2], vec![2, 1, 2, 1])
    ); // 9
    println!("{}", earliest_full_bloom(vec![1], vec![1])); // 2
    println!(
        "{}",
        earliest_full_bloom(vec![3, 1, 5, 3], vec![2, 3, 1, 4])
    ); // 13
}
