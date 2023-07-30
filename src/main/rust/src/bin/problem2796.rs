// https://leetcode.com/problems/number-of-employees-who-met-the-target/
pub fn number_of_employees_who_met_target(hours: Vec<i32>, target: i32) -> i32 {
    hours.into_iter().filter(|h| *h as i32 >= target).count() as i32
}

fn main() {
    println!(
        "{}",
        number_of_employees_who_met_target(vec![0, 1, 2, 3, 4], 2)
    ); // 3
    println!(
        "{}",
        number_of_employees_who_met_target(vec![5, 1, 4, 2, 2], 6)
    ); // 0
}
