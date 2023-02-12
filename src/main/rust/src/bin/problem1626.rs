// https://leetcode.com/problems/best-team-with-no-conflicts/
pub fn best_team_score(scores: Vec<i32>, ages: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        best_team_score(vec![1, 3, 5, 10, 15], vec![1, 2, 3, 4, 5])
    ); // 34
    println!("{}", best_team_score(vec![4, 5, 6, 5], vec![2, 1, 2, 1])); // 16
    println!("{}", best_team_score(vec![1, 2, 3, 5], vec![8, 9, 10, 1])); // 6
}
