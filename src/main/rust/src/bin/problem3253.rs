// https://leetcode.com/problems/construct-string-with-minimum-cost-easy/description/
pub fn minimum_cost(target: String, words: Vec<String>, costs: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        minimum_cost(
            "abcdef".to_string(),
            vec![
                "abdef".to_string(),
                "abc".to_string(),
                "d".to_string(),
                "def".to_string(),
                "ef".to_string()
            ],
            vec![100, 1, 1, 10, 5]
        )
    ); // 7
    println!(
        "{}",
        minimum_cost(
            "aaaa".to_string(),
            vec!["z".to_string(), "zz".to_string(), "zzz".to_string()],
            vec![1, 10, 100]
        )
    ); // -1
}
