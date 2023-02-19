// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
pub fn min_max_difference(num: i32) -> i32 {
    let s: Vec<char> = format!("{}", num).chars().collect();
    let mut first_max_index = 0;
    while first_max_index < s.len() && s[first_max_index] == '9' {
        first_max_index += 1;
    }
    let max: i32 = (if first_max_index == s.len() {
        s.iter().collect::<String>()
    } else {
        s.iter()
            .map(|c| if *c == s[first_max_index] { '9' } else { *c })
            .collect::<String>()
    })
    .parse()
    .unwrap();
    let min: i32 = s
        .iter()
        .map(|c| if *c == s[0] { '0' } else { *c })
        .collect::<String>()
        .parse()
        .unwrap();
    (max - min).abs()
}

fn main() {
    println!("{}", min_max_difference(11891)); // 99009
    println!("{}", min_max_difference(90)); // 99
    println!("{}", min_max_difference(78891)); // 90000
    println!("{}", min_max_difference(99999)); // 99999
}
