// https://leetcode.com/problems/words-within-two-edits-of-dictionary/
pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
    fn is_two_edit_distance(s1: &str, s2: &str) -> bool {
        if s1.len() != s2.len() {
            return false;
        }
        let mut count = 0;
        let bytes1 = s1.as_bytes();
        let bytes2 = s2.as_bytes();
        for i in 0..s1.len() {
            if bytes1[i] != bytes2[i] {
                count += 1;
            }
            if count > 2 {
                return false;
            }
        }
        true
    }

    let mut answer: Vec<String> = vec![];
    for query in queries.iter() {
        for word in dictionary.iter() {
            if is_two_edit_distance(query, word) {
                answer.push(query.clone());
                break;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        two_edit_words(
            vec![
                "word".to_string(),
                "note".to_string(),
                "ants".to_string(),
                "wood".to_string()
            ],
            vec!["wood".to_string(), "joke".to_string(), "moat".to_string()]
        )
    ); // ["word","note","wood"]
    println!(
        "{:?}",
        two_edit_words(vec!["yes".to_string()], vec!["not".to_string()])
    ); // []
}
