// https://leetcode.com/problems/last-visited-integers/description/
pub fn last_visited_integers(words: Vec<String>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        last_visited_integers(vec![
            "1".to_string(),
            "2".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string()
        ])
    ); // [2,1,-1]
    println!(
        "{:?}",
        last_visited_integers(vec![
            "1".to_string(),
            "prev".to_string(),
            "2".to_string(),
            "prev".to_string(),
            "prev".to_string()
        ])
    ); // [1,2,1]
    println!(
        "{:?}",
        last_visited_integers(vec![
            "1".to_string(),
            "2".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "3".to_string(),
            "prev".to_string()
        ])
    ); // [2,1,-1,-1,-1,3]
}
