// https://leetcode.com/problems/perform-string-shifts/description/
pub fn string_shift(s: String, shift: Vec<Vec<i32>>) -> String {
    let chars: Vec<char> = s.chars().collect();
    let mut i = 0;
    for v in shift {
        let direction = v[0];
        let amount = v[1];
        if direction == 1 {
            i = (i + amount) % s.len() as i32;
        } else {
            let j = (i - amount) % chars.len() as i32;
            i = if j < 0 { s.len() as i32 + j } else { j };
        }
    }
    let mut answer = vec![' '; chars.len()];
    let mut i = i as usize;
    for j in 0..chars.len() {
        answer[i] = chars[j];
        i = (i + 1) % chars.len();
    }
    answer.into_iter().collect()
}

fn main() {
    println!(
        "{}",
        string_shift("abc".to_string(), vec![vec![0, 1], vec![1, 2]])
    ); // "cab"
    println!(
        "{}",
        string_shift(
            "abcdefg".to_string(),
            vec![vec![1, 1], vec![1, 1], vec![0, 2], vec![1, 3]]
        )
    ); // "efgabcd"
}
