// https://leetcode.com/problems/split-concatenated-strings/description/
pub fn split_looped_string(mut strs: Vec<String>) -> String {
    for i in 0..strs.len() {
        let rev = strs[i].chars().rev().collect::<String>();
        if strs[i] < rev {
            strs[i] = rev;
        }
    }
    let mut answer = String::new();
    for i in 0..strs.len() {
        let rev = strs[i].chars().rev().collect::<String>();
        for s in vec![strs[i].as_str(), rev.as_str()] {
            for j in 0..s.len() {
                let mut new_string = (&s[j..]).to_string();
                for k in i + 1..strs.len() {
                    new_string.push_str(&strs[k]);
                }
                for k in 0..i {
                    new_string.push_str(&strs[k]);
                }
                new_string.push_str(&s[0..j]);
                if new_string > answer {
                    answer = new_string;
                }
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        split_looped_string(vec!["abc".to_string(), "xyz".to_string()])
    ); // "zyxcba"
    println!("{}", split_looped_string(vec!["abc".to_string()])); // "cba"
    println!("{}", split_looped_string(vec!["xyz".to_string()])); // "zyx"
    println!(
        "{}",
        split_looped_string(vec![
            "abc".to_string(),
            "def".to_string(),
            "xyz".to_string()
        ])
    ); // "zyxcbafed"
    println!(
        "{}",
        split_looped_string(vec![
            "xab".to_string(),
            "axz".to_string(),
            "xyz".to_string()
        ])
    ); // "zzyxxabax"
    println!(
        "{}",
        split_looped_string(vec!["a".to_string(), "b".to_string(), "c".to_string()])
    ); // "cab"
    println!(
        "{}",
        split_looped_string(vec!["yzy".to_string(), "aba".to_string()])
    ); // "zyabay"
}
