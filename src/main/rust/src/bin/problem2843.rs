// https://leetcode.com/problems/count-symmetric-integers/
pub fn count_symmetric_integers(low: i32, high: i32) -> i32 {
    let mut answer = 0;
    for i in low..=high {
        let chars: Vec<char> = format!("{}", i).chars().collect();
        if chars.len() % 2 == 0 {
            let left_sum: i32 = chars[0..chars.len() / 2]
                .iter()
                .map(|c| *c as i32 - '0' as i32)
                .sum();
            let right_sum: i32 = chars[chars.len() / 2..chars.len()]
                .iter()
                .map(|c| *c as i32 - '0' as i32)
                .sum();
            if left_sum == right_sum {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_symmetric_integers(1, 100)); // 9
    println!("{}", count_symmetric_integers(1200, 1230)); // 4
}
