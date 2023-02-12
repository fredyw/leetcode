// https://leetcode.com/problems/count-vowel-strings-in-ranges/
pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
    fn is_vowel(byte: u8) -> bool {
        byte == 'a' as u8
            || byte == 'e' as u8
            || byte == 'i' as u8
            || byte == 'o' as u8
            || byte == 'u' as u8
    }

    let mut prefix: Vec<i32> = vec![0; words.len()];
    for (i, word) in words.iter().enumerate() {
        let bytes = word.as_bytes();
        prefix[i] += if i == 0 { 0 } else { prefix[i - 1] };
        if is_vowel(bytes[0]) && is_vowel(bytes[bytes.len() - 1]) {
            prefix[i] += 1;
        }
    }
    let mut answer = vec![];
    for query in queries.into_iter() {
        let from = query[0] as usize;
        let to = query[1] as usize;
        answer.push(prefix[to] - if from == 0 { 0 } else { prefix[from - 1] });
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        vowel_strings(
            vec![
                "aba".to_string(),
                "bcb".to_string(),
                "ece".to_string(),
                "aa".to_string(),
                "e".to_string()
            ],
            vec![vec![0, 2], vec![1, 4], vec![1, 1]]
        )
    ); // [2,3,0]
    println!(
        "{:?}",
        vowel_strings(
            vec!["a".to_string(), "e".to_string(), "i".to_string()],
            vec![vec![0, 2], vec![0, 1], vec![2, 2]]
        )
    ); // [3,2,1]
}
