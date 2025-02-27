// https://leetcode.com/problems/synonymous-sentences/description/
pub fn generate_sentences(synonyms: Vec<Vec<String>>, text: String) -> Vec<String> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        generate_sentences(
            vec![
                vec!["happy".to_string(), "joy".to_string()],
                vec!["sad".to_string(), "sorrow".to_string()],
                vec!["joy".to_string(), "cheerful".to_string()]
            ],
            "I am happy today but was sad yesterday".to_string()
        )
    ); // ["I am cheerful today but was sad yesterday","I am cheerful today but was sorrow yesterday","I am happy today but was sad yesterday","I am happy today but was sorrow yesterday","I am joy today but was sad yesterday","I am joy today but was sorrow yesterday"]
    println!(
        "{:?}",
        generate_sentences(
            vec![
                vec!["happy".to_string(), "joy".to_string()],
                vec!["cheerful".to_string(), "glad".to_string()]
            ],
            "I am happy today but was sad yesterday".to_string()
        )
    ); // ["I am happy today but was sad yesterday","I am joy today but was sad yesterday"]
}
