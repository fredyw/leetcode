use std::collections::{BTreeSet, HashMap};

// https://leetcode.com/problems/synonymous-sentences/description/
pub fn generate_sentences(synonyms: Vec<Vec<String>>, text: String) -> Vec<String> {
    fn gen(
        synonyms: &HashMap<String, String>,
        words: &mut Vec<String>,
        indexes: &Vec<usize>,
        index: usize,
        sentences: &mut BTreeSet<String>,
    ) {
        sentences.insert(words.join(" "));
        if index == indexes.len() {
            return;
        }
        let from = words[indexes[index]].clone();
        while let Some(to) = synonyms.get(&words[indexes[index]]) {
            words[indexes[index]] = to.clone();
            gen(synonyms, words, indexes, index + 1, sentences);
        }
        words[indexes[index]] = from;
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
    for i in 0..indexes.len() {
        gen(&synonyms, &mut words, &indexes, i, &mut answer);
    }
    answer.into_iter().collect()
}

fn main() {
    // println!(
    //     "{:?}",
    //     generate_sentences(
    //         vec![
    //             vec!["happy".to_string(), "joy".to_string()],
    //             vec!["sad".to_string(), "sorrow".to_string()],
    //             vec!["joy".to_string(), "cheerful".to_string()]
    //         ],
    //         "I am happy today but was sad yesterday".to_string()
    //     )
    // ); // ["I am cheerful today but was sad yesterday","I am cheerful today but was sorrow yesterday","I am happy today but was sad yesterday","I am happy today but was sorrow yesterday","I am joy today but was sad yesterday","I am joy today but was sorrow yesterday"]
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
    // println!(
    //     "{:?}",
    //     generate_sentences(
    //         vec![
    //             vec!["a".to_string(), "b".to_string()],
    //             vec!["b".to_string(), "c".to_string()],
    //             vec!["x".to_string(), "y".to_string()],
    //             vec!["y".to_string(), "z".to_string()],
    //         ],
    //         "a x".to_string()
    //     )
    // ); // ["a x","a y","a z","b x","b y","b z","c x","c y","c z"]
    println!(
        "{:?}",
        generate_sentences(
            vec![
                vec!["a".to_string(), "b".to_string()],
                vec!["x".to_string(), "y".to_string()],
                vec!["i".to_string(), "j".to_string()],
            ],
            "a x i".to_string()
        )
    ); // ["a x i","a x j","a y i","a y j","b x i","b x j","b y i","b y j"]
}
