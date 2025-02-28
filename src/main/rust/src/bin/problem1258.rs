use std::collections::{BTreeSet, HashMap, HashSet};

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
        gen(synonyms, words, indexes, index + 1, sentences);
        let mut visited: HashSet<String> = HashSet::new();
        while let Some(to) = synonyms.get(&words[indexes[index]]) {
            if visited.contains(to) {
                break;
            }
            visited.insert(to.clone());
            words[indexes[index]] = to.clone();
            gen(synonyms, words, indexes, index + 1, sentences);
        }
        words[indexes[index]] = from;
    }

    let mut synonym_map: HashMap<&str, Vec<&str>> = HashMap::new();
    for synonym in synonyms.iter() {
        synonym_map
            .entry(&synonym[0])
            .or_insert(vec![])
            .push(&synonym[1]);
        synonym_map
            .entry(&synonym[1])
            .or_insert(vec![])
            .push(&synonym[0]);
    }

    // .into_iter()
    // .flat_map(|v| {
    //     vec![
    //         (v[0].to_owned(), v[1].to_owned()),
    //         (v[1].to_owned(), v[0].to_owned()),
    //     ]
    //     .into_iter()
    // })
    // .collect();
    let mut words: Vec<String> = text.split(" ").map(|w| w.to_owned()).collect();
    let mut indexes: Vec<usize> = vec![];
    for (i, word) in words.iter().enumerate() {
        if synonyms.contains_key(word) {
            indexes.push(i);
        }
    }
    let mut answer = BTreeSet::new();
    gen(&synonyms, &mut words, &indexes, 0, &mut answer);
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
    // println!(
    //     "{:?}",
    //     generate_sentences(
    //         vec![
    //             vec!["a".to_string(), "b".to_string()],
    //             vec!["x".to_string(), "y".to_string()],
    //             vec!["i".to_string(), "j".to_string()],
    //         ],
    //         "a x i".to_string()
    //     )
    // ); // ["a x i","a x j","a y i","a y j","b x i","b x j","b y i","b y j"]
    // println!(
    //     "{:?}",
    //     generate_sentences(
    //         vec![vec!["a".to_string(), "QrbCl".to_string()]],
    //         "d QrbCl ya ya NjZQ".to_string()
    //     )
    // ); // ["d QrbCl ya ya NjZQ","d a ya ya NjZQ"]
    println!(
        "{:?}",
        generate_sentences(
            vec![
                vec!["a".to_string(), "b".to_string()],
                vec!["b".to_string(), "c".to_string()],
                vec!["d".to_string(), "e".to_string()],
                vec!["c".to_string(), "d".to_string()]
            ],
            "a b".to_string()
        )
    ); // ["a a","a b","a c","a d","a e","b a","b b","b c","b d","b e","c a","c b","c c","c d","c e","d a","d b","d c","d d","d e","e a","e b","e c","e d","e e"]
}
