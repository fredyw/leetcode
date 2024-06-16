// https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/description/
pub fn count_complete_day_pairs(hours: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..hours.len() {
        for j in i + 1..hours.len() {
            if (hours[i] + hours[j]) % 24 == 0 {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_complete_day_pairs(vec![12, 12, 30, 24, 24])); // 2
    println!("{}", count_complete_day_pairs(vec![72, 48, 24, 3])); // 3
}
