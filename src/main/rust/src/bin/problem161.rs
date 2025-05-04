// https://leetcode.com/problems/one-edit-distance/description/
pub fn is_one_edit_distance(s: String, t: String) -> bool {
    fn is_one_edit_distance(
        s: &Vec<char>,
        t: &Vec<char>,
        i: usize,
        j: usize,
        change: bool,
        memo: &mut Vec<Vec<Vec<i32>>>,
    ) -> bool {
        if i >= s.len() && j >= t.len() && change {
            return true;
        }
        if i >= s.len() || j >= t.len() {
            return false;
        }
        if change && s[i] != t[j] {
            return false;
        }
        let c = if change { 1 } else { 0 };
        if memo[i][j][c] != -1 {
            return memo[i][j][c] == 1;
        }
        let has_change = (i as i32 - j as i32).abs() >= 1 || s[i] != t[j] || change;
        let remove = is_one_edit_distance(s, t, i, j + 1, has_change, memo);
        let add = is_one_edit_distance(s, t, i + 1, j, has_change, memo);
        let replace = is_one_edit_distance(s, t, i + 1, j + 1, has_change, memo);
        let found = remove || add || replace;
        memo[i][j][c] = if found { 1 } else { 0 };
        found
    }

    if s == t || (s.len() as i32 - t.len() as i32).abs() > 1 {
        return false;
    }
    if s.len() <= 1 && t.len() <= 1 {
        return true;
    }
    let s: Vec<char> = s.chars().collect();
    let t: Vec<char> = t.chars().collect();
    is_one_edit_distance(
        &s,
        &t,
        0,
        0,
        false,
        &mut vec![vec![vec![-1; 2]; t.len()]; s.len()],
    )
}

fn main() {
    println!(
        "{}",
        is_one_edit_distance("ab".to_string(), "acb".to_string())
    ); // true
    println!("{}", is_one_edit_distance("".to_string(), "".to_string())); // false
    println!(
        "{}",
        is_one_edit_distance("ab".to_string(), "a".to_string())
    ); // true
    println!(
        "{}",
        is_one_edit_distance("ab".to_string(), "ar".to_string())
    ); // true
    println!("{}", is_one_edit_distance("a".to_string(), "".to_string())); // true
    println!(
        "{}",
        is_one_edit_distance("ab".to_string(), "ab".to_string())
    ); // false
    println!(
        "{}",
        is_one_edit_distance("aaaaaaaaa".to_string(), "aaaaaaaaaa".to_string())
    ); // true
    println!(
        "{}",
        is_one_edit_distance("a".to_string(), "aa".to_string())
    ); // true
    println!(
        "{}",
        is_one_edit_distance("aa".to_string(), "a".to_string())
    ); // true
}
