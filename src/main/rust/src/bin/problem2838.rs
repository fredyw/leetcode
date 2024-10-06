// https://leetcode.com/problems/maximum-coins-heroes-can-collect/description/
pub fn maximum_coins(heroes: Vec<i32>, monsters: Vec<i32>, coins: Vec<i32>) -> Vec<i64> {
    fn get_coins(monster: &Vec<(i32, i32)>, hero: i32) -> i64 {
        0
    }

    let mut monsters: Vec<(i32, i32)> = monsters
        .into_iter()
        .enumerate()
        .map(|(i, m)| (m, coins[i]))
        .collect();
    monsters.sort();
    let mut answer = vec![];
    for hero in heroes {
        answer.push(get_coins(&monsters, hero));
    }
    answer
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
