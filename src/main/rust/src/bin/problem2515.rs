// https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/
pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        closet_target(
            vec![
                "hello".to_string(),
                "i".to_string(),
                "am".to_string(),
                "leetcode".to_string(),
                "hello".to_string()
            ],
            "hello".to_string(),
            1
        )
    ); // 1
    println!(
        "{}",
        closet_target(
            vec!["a".to_string(), "b".to_string(), "leetcode".to_string()],
            "leetcode".to_string(),
            0
        )
    ); // 1
    println!(
        "{}",
        closet_target(
            vec!["i".to_string(), "eat".to_string(), "leetcode".to_string()],
            "ate".to_string(),
            0
        )
    ); // -1
}
