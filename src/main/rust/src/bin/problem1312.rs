// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
pub fn min_insertions(s: String) -> i32 {
    fn min_insertions(chars: &Vec<char>, i: usize, j: usize, memo: &mut Vec<Vec<i32>>) -> i32 {
        if i >= j {
            return 0;
        }
        if memo[i][j] != -1 {
            return memo[i][j];
        }
        let mut min = i32::MAX;
        if chars[i] == chars[j] {
            min = min.min(min_insertions(chars, i + 1, j - 1, memo));
        } else {
            let left = min_insertions(chars, i + 1, j, memo) + 1;
            let right = min_insertions(chars, i, j - 1, memo) + 1;
            min = min.min(left.min(right));
        }
        memo[i][j] = min;
        min
    }

    let chars: Vec<char> = s.chars().collect();
    min_insertions(
        &chars,
        0,
        chars.len() - 1,
        &mut vec![vec![-1; chars.len()]; chars.len()],
    )
}

fn main() {
    println!("{}", min_insertions("zzazz".to_string())); // 0
    println!("{}", min_insertions("mbadm".to_string())); // 2
    println!("{}", min_insertions("leetcode".to_string())); // 5
    println!("{}", min_insertions("zjveiiwvc".to_string())); // 5
    println!("{}", min_insertions("zjveieiwvc".to_string())); // 5
}
