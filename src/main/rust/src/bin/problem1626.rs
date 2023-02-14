// https://leetcode.com/problems/best-team-with-no-conflicts/
pub fn best_team_score(scores: Vec<i32>, ages: Vec<i32>) -> i32 {
    fn best_team_score(
        ages_and_scores: &Vec<(i32, i32)>,
        prev_index: usize,
        index: usize,
        memo: &mut Vec<Vec<i32>>,
    ) -> i32 {
        if index == ages_and_scores.len() {
            return 0;
        }
        if memo[prev_index][index] != -1 {
            return memo[prev_index][index];
        }
        let (prev_age, prev_score) = ages_and_scores[prev_index];
        let (age, score) = ages_and_scores[index];
        if prev_age < age && score < prev_score {
            return best_team_score(ages_and_scores, prev_index, index + 1, memo);
        }
        let take = best_team_score(ages_and_scores, index, index + 1, memo) + score;
        let skip = best_team_score(ages_and_scores, prev_index, index + 1, memo);
        let max = take.max(skip);
        memo[prev_index][index] = max;
        max
    }

    let mut ages_and_scores: Vec<(i32, i32)> = ages.into_iter().zip(scores).collect();
    ages_and_scores.sort();
    let mut memo: Vec<Vec<i32>> = vec![vec![-1; 1001]; 1001];
    let mut answer = 0;
    for i in 0..ages_and_scores.len() {
        answer = answer.max(best_team_score(&ages_and_scores, i, i, &mut memo));
    }
    answer
}

fn main() {
    println!(
        "{}",
        best_team_score(vec![1, 3, 5, 10, 15], vec![1, 2, 3, 4, 5])
    ); // 34
    println!("{}", best_team_score(vec![4, 5, 6, 5], vec![2, 1, 2, 1])); // 16
    println!("{}", best_team_score(vec![1, 2, 3, 5], vec![8, 9, 10, 1])); // 6
}
