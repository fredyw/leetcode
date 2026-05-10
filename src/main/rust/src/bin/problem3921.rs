// https://leetcode.com/problems/score-validator/description/
pub fn score_validator(events: Vec<String>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        score_validator(vec![
            "1".to_string(),
            "4".to_string(),
            "W".to_string(),
            "6".to_string(),
            "WD".to_string()
        ])
    ); // [12,1]
    println!(
        "{:?}",
        score_validator(vec![
            "WD".to_string(),
            "NB".to_string(),
            "0".to_string(),
            "4".to_string(),
            "4".to_string()
        ])
    ); // [10, 0]
    println!(
        "{:?}",
        score_validator(vec![
            "W".to_string(),
            "W".to_string(),
            "W".to_string(),
            "W".to_string(),
            "W".to_string(),
            "W".to_string(),
            "W".to_string(),
            "W".to_string(),
            "W".to_string(),
            "W".to_string(),
            "W".to_string()
        ])
    ); // [0,10]
}
