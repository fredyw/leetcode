// https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/
pub fn min_number_of_hours(
    initial_energy: i32,
    initial_experience: i32,
    energy: Vec<i32>,
    experience: Vec<i32>,
) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_number_of_hours(5, 3, vec![1, 4, 3, 2], vec![2, 6, 3, 1])
    ); // 8
    println!("{}", min_number_of_hours(2, 4, vec![1], vec![3])); // 0
}
