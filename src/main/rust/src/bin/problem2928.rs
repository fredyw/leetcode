// https://leetcode.com/problems/distribute-candies-among-children-i/description/
pub fn distribute_candies(n: i32, limit: i32) -> i32 {
    let mut answer = 0;
    for i in 0..=limit {
        for j in 0..=limit {
            for k in 0..=limit {
                if i + j + k == n {
                    answer += 1;
                }
            }
        }
    }
    answer
}

fn main() {
    println!("{}", distribute_candies(5, 2)); // 3
    println!("{}", distribute_candies(3, 3)); // 10
    println!("{}", distribute_candies(10, 3)); // 0
    println!("{}", distribute_candies(9, 3)); // 1
}
