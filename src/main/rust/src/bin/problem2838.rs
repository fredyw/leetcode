// https://leetcode.com/problems/maximum-coins-heroes-can-collect/description/
pub fn maximum_coins(heroes: Vec<i32>, monsters: Vec<i32>, coins: Vec<i32>) -> Vec<i64> {
    fn get_coins(monster_sums: &Vec<(i32, i64)>, hero: i32) -> i64 {
        let mut low: isize = 0;
        let mut high = monster_sums.len() as isize - 1;
        while low <= high {
            let mid = low + (high - low) / 2;
            if monster_sums[mid as usize].0 <= hero {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if high < 0 {
            0
        } else {
            monster_sums[high as usize].1
        }
    }

    let mut monsters: Vec<(i32, i32)> = monsters
        .into_iter()
        .enumerate()
        .map(|(i, m)| (m, coins[i]))
        .collect();
    monsters.sort();
    let mut monster_sums: Vec<(i32, i64)> = vec![];
    let mut prefix_sum = 0;
    for (i, (m, c)) in monsters.into_iter().enumerate() {
        prefix_sum += c as i64;
        monster_sums.push((m, prefix_sum));
    }
    let mut answer = vec![];
    for hero in heroes {
        answer.push(get_coins(&monster_sums, hero));
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
