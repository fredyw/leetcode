// https://leetcode.com/problems/faulty-sensor/description/
pub fn bad_sensor(sensor1: Vec<i32>, sensor2: Vec<i32>) -> i32 {
    for i in 0..sensor1.len() {
        if sensor1[i] != sensor2[i] {
            if i == sensor1.len() - 1 {
                break;
            }
            if sensor1[i] == sensor2[i + 1] && sensor2[i] == sensor1[i + 1] {
                continue;
            }
            if sensor1[i] == sensor2[i + 1] {
                return 1;
            }
            if sensor2[i] == sensor1[i + 1] {
                return 2;
            }
        }
    }
    -1
}

fn main() {
    println!("{}", bad_sensor(vec![2, 3, 4, 5], vec![2, 1, 3, 4])); // 1
    println!("{}", bad_sensor(vec![2, 2, 2, 2, 2], vec![2, 2, 2, 2, 5])); // -1
    println!(
        "{}",
        bad_sensor(vec![2, 3, 2, 2, 3, 2], vec![2, 3, 2, 3, 2, 7])
    ); // 2
    println!(
        "{}",
        bad_sensor(vec![2, 3, 2, 3, 2, 7], vec![2, 3, 2, 2, 3, 2])
    ); // 1
}
