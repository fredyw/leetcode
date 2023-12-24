// https://leetcode.com/problems/minimum-number-game/description/
pub fn number_game(mut nums: Vec<i32>) -> Vec<i32> {
    nums.sort();
    let mut i = 0;
    while i + 1 < nums.len() {
        nums.swap(i, i + 1);
        i += 2;
    }
    nums
}

fn main() {
    println!("{:?}", number_game(vec![5, 4, 2, 3])); // [3,2,5,4]
    println!("{:?}", number_game(vec![2, 5])); // [5,2]
}
