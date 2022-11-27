// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
pub fn minimum_fuel_cost(roads: Vec<Vec<i32>>, seats: i32) -> i64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        minimum_fuel_cost(vec![vec![0, 1], vec![0, 2], vec![0, 3]], 5)
    ); // 3
    println!(
        "{}",
        minimum_fuel_cost(
            vec![
                vec![3, 1],
                vec![3, 2],
                vec![1, 0],
                vec![0, 4],
                vec![0, 5],
                vec![4, 6]
            ],
            2
        )
    ); // 7
    println!("{}", minimum_fuel_cost(vec![], 1)); // 0
    println!(
        "{}",
        minimum_fuel_cost(vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 4]], 2)
    ); // 6
    println!(
        "{}",
        minimum_fuel_cost(vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![3, 4]], 1)
    ); // 10
}
