// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
pub fn garbage_collection(garbage: Vec<String>, travel: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        garbage_collection(
            vec![
                "G".to_string(),
                "P".to_string(),
                "GP".to_string(),
                "GG".to_string()
            ],
            vec![2, 4, 3]
        )
    ); // 21
    println!(
        "{}",
        garbage_collection(
            vec!["MMM".to_string(), "PGM".to_string(), "GP".to_string()],
            vec![3, 10]
        )
    ); // 37
}
