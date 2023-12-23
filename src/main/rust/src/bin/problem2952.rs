// https://leetcode.com/problems/minimum-number-of-coins-to-be-added/description/
pub fn minimum_added_coins(mut coins: Vec<i32>, target: i32) -> i32 {
    coins.sort();
    let mut answer = 0;
    let mut sum = 0;
    let mut i = 0;
    while sum < target {
        if i < coins.len() {
            if sum + 1 < coins[i] {
                sum += sum + 1;
                answer += 1;
            } else {
                sum += coins[i];
                i += 1;
            }
        } else {
            sum += sum + 1;
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", minimum_added_coins(vec![1, 4, 10], 19)); // 2
    println!("{}", minimum_added_coins(vec![1, 4, 10, 5, 7, 19], 19)); // 1
    println!("{}", minimum_added_coins(vec![1, 1, 1], 20)); // 3
    println!("{}", minimum_added_coins(vec![3, 3, 4, 5], 10)); // 2
    println!("{}", minimum_added_coins(vec![3, 3, 5], 20)); // 3
}
