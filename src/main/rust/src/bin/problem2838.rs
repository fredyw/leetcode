// https://leetcode.com/problems/maximum-coins-heroes-can-collect/description/
pub fn maximum_coins(heroes: Vec<i32>, monsters: Vec<i32>, coins: Vec<i32>) -> Vec<i64> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        maximum_coins(vec![1, 4, 2], vec![1, 1, 5, 2, 3], vec![2, 3, 4, 5, 6])
    ); // [5,16,10]
    println!(
        "{:?}",
        maximum_coins(vec![5], vec![2, 3, 1, 2], vec![10, 6, 5, 2])
    ); // [23]
    println!(
        "{:?}",
        maximum_coins(vec![4, 4], vec![5, 7, 8], vec![1, 1, 1])
    ); // [0,0]
}
