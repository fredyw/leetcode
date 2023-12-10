// https://leetcode.com/problems/count-tested-devices-after-test-operations/description/
pub fn count_tested_devices(battery_percentages: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut decrement = 0;
    for &percentage in battery_percentages.iter() {
        if percentage - decrement > 0 {
            answer += 1;
            decrement += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_tested_devices(vec![1, 1, 2, 1, 3])); // 3
    println!("{}", count_tested_devices(vec![0, 1, 2])); // 2
}
