// https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/
pub fn number_of_cuts(n: i32) -> i32 {
    if n == 1 {
        0
    } else if n % 2 == 0 {
        n / 2
    } else {
        n
    }
}

fn main() {
    println!("{}", number_of_cuts(4)); // 2
    println!("{}", number_of_cuts(3)); // 3
    println!("{}", number_of_cuts(2)); // 1
    println!("{}", number_of_cuts(1)); // 0
    println!("{}", number_of_cuts(5)); // 5
    println!("{}", number_of_cuts(6)); // 3
}
