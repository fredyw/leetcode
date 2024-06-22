// https://leetcode.com/problems/index-pairs-of-a-string/description/
pub fn index_pairs(text: String, words: Vec<String>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        index_pairs(
            "thestoryofleetcodeandme".to_string(),
            vec![
                "story".to_string(),
                "fleet".to_string(),
                "leetcode".to_string()
            ]
        )
    ); // [[3,7],[9,13],[10,17]]
    println!(
        "{:?}",
        index_pairs(
            "ababa".to_string(),
            vec!["aba".to_string(), "ab".to_string()]
        )
    ); // [[0,1],[0,2],[2,3],[2,4]]
}
