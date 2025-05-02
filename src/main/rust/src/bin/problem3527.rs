// https://leetcode.com/problems/find-the-most-common-response/
pub fn find_common_response(responses: Vec<Vec<String>>) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        find_common_response(vec![
            vec![
                "good".to_string(),
                "ok".to_string(),
                "good".to_string(),
                "ok".to_string()
            ],
            vec![
                "ok".to_string(),
                "bad".to_string(),
                "good".to_string(),
                "ok".to_string(),
                "ok".to_string()
            ],
            vec!["good".to_string()],
            vec!["bad".to_string()]
        ])
    ); // "good"
    println!(
        "{}",
        find_common_response(vec![
            vec!["good".to_string(), "ok".to_string(), "good".to_string()],
            vec!["ok".to_string(), "bad".to_string()],
            vec!["bad".to_string(), "notsure".to_ascii_lowercase()],
            vec!["great".to_string(), "good".to_string()]
        ])
    ); // "bad"
}
