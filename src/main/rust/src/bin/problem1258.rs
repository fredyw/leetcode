use std::collections::{BTreeSet, HashMap};

// https://leetcode.com/problems/synonymous-sentences/description/
pub fn generate_sentences(synonyms: Vec<Vec<String>>, text: String) -> Vec<String> {
    fn gen(
        synonyms: &HashMap<String, String>,
        words: &mut Vec<String>,
        indexes: &Vec<usize>,
        sentences: &mut BTreeSet<String>,
    ) {
        sentences.insert(words.join(" "));
        for i in indexes.iter() {
            while let Some(s) = synonyms.get(&words[*i]) {
                words.push(s.clone());
                gen(synonyms, words, indexes, sentences);
                words.push(words[*i].clone());
            }
        }
    }

    let synonyms: HashMap<String, String> = synonyms
        .into_iter()
        .map(|v| (v[0].to_owned(), v[1].to_owned()))
        .collect();
    let mut words: Vec<String> = text.split(" ").map(|w| w.to_owned()).collect();
    let mut indexes: Vec<usize> = vec![];
    for (i, word) in words.iter().enumerate() {
        if synonyms.contains_key(word) {
            indexes.push(i);
        }
    }
    let mut answer = BTreeSet::new();
    gen(&synonyms, &mut words, &indexes, &mut answer);
    answer.into_iter().collect()
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
       // println!(
       //     "{:?}",
       //     generate_sentences(
       //         vec![
       //             vec!["happy".to_string(), "joy".to_string()],
       //             vec!["cheerful".to_string(), "glad".to_string()]
       //         ],
       //         "I am happy today but was sad yesterday".to_string()
       //     )
       // ); // ["I am happy today but was sad yesterday","I am joy today but was sad yesterday"]
}
