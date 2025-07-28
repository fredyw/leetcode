// https://leetcode.com/problems/sort-threats-by-severity-and-exploitability/description/
pub fn sort_threats(threats: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
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
