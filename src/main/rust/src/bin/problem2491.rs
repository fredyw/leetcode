// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/
pub fn divide_players(mut skill: Vec<i32>) -> i64 {
    skill.sort();
    let mut answer: i64 = 0;
    let mut i = 0;
    let mut j = skill.len() - 1;
    let mut equal_skill = 0;
    while i < j {
        let sum = skill[i] + skill[j];
        if equal_skill == 0 || equal_skill == sum {
            answer += skill[i] as i64 * skill[j] as i64;
            equal_skill = sum;
        } else {
            return -1;
        }
        i += 1;
        j -= 1;
    }
    answer
}

fn main() {
    println!("{}", divide_players(vec![3, 2, 5, 1, 3, 4])); // 22
    println!("{}", divide_players(vec![3, 4])); // 12
    println!("{}", divide_players(vec![1, 1, 2, 3])); // -1
}
