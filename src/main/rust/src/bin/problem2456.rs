// https://leetcode.com/problems/most-popular-video-creator/
pub fn most_popular_creator(
    creators: Vec<String>,
    ids: Vec<String>,
    views: Vec<i32>,
) -> Vec<Vec<String>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        most_popular_creator(
            vec![
                "alice".to_string(),
                "bob".to_string(),
                "alice".to_string(),
                "chris".to_string()
            ],
            vec![
                "one".to_string(),
                "two".to_string(),
                "three".to_string(),
                "four".to_string()
            ],
            vec![5, 10, 5, 4]
        )
    ); // [["alice","one"],["bob","two"]]
    println!(
        "{:?}",
        most_popular_creator(
            vec![
                "alice".to_string(),
                "alice".to_string(),
                "alice".to_string()
            ],
            vec!["a".to_string(), "b".to_string(), "c".to_string(),],
            vec![1, 2, 2]
        )
    ); // [["alice","b"]]
}
