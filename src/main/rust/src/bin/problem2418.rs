// https://leetcode.com/problems/sort-the-people/
pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
    let mut v: Vec<(i32, String)> = heights.into_iter().zip(names.into_iter()).collect();
    v.sort_by(|a, b| b.cmp(a));
    v.into_iter().map(|a| a.1).clone().collect()
}

fn main() {
    println!(
        "{:?}",
        sort_people(
            vec!["Mary".to_string(), "John".to_string(), "Emma".to_string()],
            vec![180, 165, 170]
        )
    ); // ["Mary","Emma","John"]
    println!(
        "{:?}",
        sort_people(
            vec!["Alice".to_string(), "Bob".to_string(), "Bob".to_string()],
            vec![155, 185, 150]
        )
    ); // ["Bob","Alice","Bob"]
}
