// https://leetcode.com/problems/faulty-sensor/description/
pub fn bad_sensor(sensor1: Vec<i32>, sensor2: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", bad_sensor(vec![2, 3, 4, 5], vec![2, 1, 3, 4])); // 1
    println!("{}", bad_sensor(vec![2, 2, 2, 2, 2], vec![2, 2, 2, 2, 5])); // -1
    println!(
        "{}",
        bad_sensor(vec![2, 3, 2, 2, 3, 2], vec![2, 3, 2, 3, 2, 7])
    ); // 2
}
