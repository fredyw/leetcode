// https://leetcode.com/problems/number-of-student-replacements/description/
pub fn total_replacements(ranks: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut min = ranks[0];
    for i in 1..ranks.len() {
        if min > ranks[i] {
            min = ranks[i];
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", total_replacements(vec![4, 1, 2])); // 1
    println!("{}", total_replacements(vec![2, 2, 3])); // 0
}
