// https://leetcode.com/problems/paint-house/description/
pub fn min_cost(costs: Vec<Vec<i32>>) -> i32 {
    fn min_cost(costs: &Vec<Vec<i32>>, i: usize, j: usize, memo: &mut Vec<Vec<i32>>) -> i32 {
        if i == costs.len() {
            return 0;
        }
        if memo[i][j] != -1 {
            return memo[i][j];
        }
        let cost = costs[i][j];
        let min_cost = if j == 0 {
            let a = min_cost(costs, i + 1, 1, memo) + cost;
            let b = min_cost(costs, i + 1, 2, memo) + cost;
            a.min(b)
        } else if j == 1 {
            let a = min_cost(costs, i + 1, 0, memo) + cost;
            let b = min_cost(costs, i + 1, 2, memo) + cost;
            a.min(b)
        } else {
            let a = min_cost(costs, i + 1, 0, memo) + cost;
            let b = min_cost(costs, i + 1, 1, memo) + cost;
            a.min(b)
        };
        memo[i][j] = min_cost;
        min_cost
    }

    let mut memo = vec![vec![-1; 3]; costs.len()];
    let a = min_cost(&costs, 0, 0, &mut memo);
    let b = min_cost(&costs, 0, 1, &mut memo);
    let c = min_cost(&costs, 0, 2, &mut memo);
    a.min(b.min(c))
}

fn main() {
    println!(
        "{}",
        min_cost(vec![vec![17, 2, 17], vec![16, 16, 5], vec![14, 3, 19]])
    ); // 10
    println!("{}", min_cost(vec![vec![7, 6, 2]])); // 2
}
