// https://leetcode.com/problems/check-distances-between-same-letters/
pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
    let mut char_indexes = vec![-1i32; 26];
    let chars: Vec<char> = s.chars().collect();
    for (i, c) in chars.into_iter().enumerate() {
        if char_indexes[c as usize - 'a' as usize] != -1 {
            if i as i32 - char_indexes[c as usize - 'a' as usize] - 1
                != distance[c as usize - 'a' as usize]
            {
                return false;
            }
        } else {
            char_indexes[c as usize - 'a' as usize] = i as i32;
        }
    }
    true
}

fn main() {
    println!(
        "{}",
        check_distances(
            "abaccb".to_string(),
            vec![1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        )
    ); // true
    println!(
        "{}",
        check_distances(
            "aa".to_string(),
            vec![1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        )
    ); // false
}
