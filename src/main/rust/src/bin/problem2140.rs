use std::cmp;

// https://leetcode.com/problems/solving-questions-with-brainpower/
pub fn most_points(questions: Vec<Vec<i32>>) -> i64 {
    fn f(questions: &Vec<Vec<i32>>, index: i32, memo: &mut Vec<i64>) -> i64 {
        if (index as usize) >= questions.len() {
            return 0;
        }
        if memo[index as usize] != -1 {
            return memo[index as usize];
        }
        let points = &questions[index as usize][0];
        let brainpower = &questions[index as usize][1];
        let solve = f(questions, index + brainpower + 1, memo) + *points as i64;
        let skip = f(questions, index + 1, memo);
        let max: i64 = cmp::max(solve, skip);
        memo[index as usize] = max;
        max
    }
    f(&questions, 0, &mut vec![-1; questions.len() as usize])
}

fn main() {
    println!(
        "{}",
        most_points(vec![vec![3, 2], vec![4, 3], vec![4, 4], vec![2, 5]])
    ); // 5
    println!(
        "{}",
        most_points(vec![
            vec![1, 1],
            vec![2, 2],
            vec![3, 3],
            vec![4, 4],
            vec![5, 5]
        ])
    ); // 7
}
