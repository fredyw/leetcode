// https://leetcode.com/problems/maximum-score-words-formed-by-letters/
pub fn max_score_words(words: Vec<String>, letters: Vec<char>, score: Vec<i32>) -> i32 {
    fn get_max_score(
        words: &Vec<String>,
        letter_counts: &mut Vec<i32>,
        scores: &Vec<i32>,
        index: usize,
    ) -> i32 {
        let mut max_score = 0;
        for i in index..words.len() {
            let word = &words[i];
            let mut chars: Vec<char> = word.chars().collect();
            if valid_word(letter_counts, &mut chars) {
                let score = get_score(scores, &chars);
                max_score =
                    max_score.max(get_max_score(words, letter_counts, scores, i + 1) + score);
                for c in chars.iter() {
                    letter_counts[*c as usize - 'a' as usize] += 1;
                }
            }
        }
        max_score
    }

    fn valid_word(letter_counts: &mut Vec<i32>, chars: &Vec<char>) -> bool {
        let mut tmp = vec![0; 26];
        for c in chars {
            let i = *c as usize - 'a' as usize;
            tmp[i] += 1;
            letter_counts[i] -= 1;
            if letter_counts[i] < 0 {
                for j in 0..tmp.len() {
                    letter_counts[j] += tmp[j];
                }
                return false;
            }
        }
        true
    }

    fn get_score(scores: &Vec<i32>, chars: &Vec<char>) -> i32 {
        let mut score = 0;
        for c in chars {
            score += scores[*c as usize - 'a' as usize];
        }
        score
    }

    let mut letter_counts = vec![0; 26];
    for c in letters {
        letter_counts[c as usize - 'a' as usize] += 1;
    }
    get_max_score(&words, &mut letter_counts, &score, 0)
}

fn main() {
    println!(
        "{}",
        max_score_words(
            vec![
                String::from("dog"),
                String::from("cat"),
                String::from("dad"),
                String::from("good")
            ],
            vec!['a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'],
            vec![1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        )
    ); // 23
    println!(
        "{}",
        max_score_words(
            vec![
                String::from("xxxz"),
                String::from("ax"),
                String::from("bx"),
                String::from("cx")
            ],
            vec!['z', 'a', 'b', 'c', 'x', 'x', 'x'],
            vec![4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10]
        )
    ); // 27
    println!(
        "{}",
        max_score_words(
            vec![String::from("leetcode")],
            vec!['l', 'e', 't', 'c', 'o', 'd'],
            vec![0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
        )
    ); // 0
}
