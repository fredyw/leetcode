// https://leetcode.com/problems/find-if-digit-game-can-be-won/description/
pub fn can_alice_win(nums: Vec<i32>) -> bool {
    let mut single_digit_count = 0;
    let mut double_digit_count = 0;
    for num in nums {
        if num < 10 {
            single_digit_count += num;
        } else {
            double_digit_count += num;
        }
    }
    single_digit_count != double_digit_count
}

fn main() {
    println!("{}", can_alice_win(vec![1, 2, 3, 4, 10])); // false
    println!("{}", can_alice_win(vec![1, 2, 3, 4, 5, 14])); // true
    println!("{}", can_alice_win(vec![5, 5, 5, 25])); // true
}
