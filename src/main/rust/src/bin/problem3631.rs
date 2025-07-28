// https://leetcode.com/problems/sort-threats-by-severity-and-exploitability/description/
pub fn sort_threats(mut threats: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    threats.sort_by(|a, b| {
        let score_a = 2 * a[1] as i64 + a[2] as i64;
        let score_b = 2 * b[1] as i64 + b[2] as i64;
        let cmp = score_b.cmp(&score_a);
        if cmp == std::cmp::Ordering::Equal {
            a[0].cmp(&b[0])
        } else {
            cmp
        }
    });
    threats
}

fn main() {
    println!(
        "{:?}",
        sort_threats(vec![vec![101, 2, 3], vec![102, 3, 2], vec![103, 3, 3]])
    ); // [[103,3,3],[102,3,2],[101,2,3]]
    println!(
        "{:?}",
        sort_threats(vec![vec![101, 4, 1], vec![103, 1, 5], vec![102, 1, 5]])
    ); // [[101,4,1],[102,1,5],[103,1,5]]
}
