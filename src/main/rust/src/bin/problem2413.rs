// https://leetcode.com/problems/smallest-even-multiple/
pub fn smallest_even_multiple(n: i32) -> i32 {
    if n % 2 == 0 {
        n
    } else {
        n * 2
    }
}

fn main() {
    println!("{}", smallest_even_multiple(5)); // 10
    println!("{}", smallest_even_multiple(6)); // 6
    println!("{}", smallest_even_multiple(7)); // 14
    println!("{}", smallest_even_multiple(1)); // 2
    println!("{}", smallest_even_multiple(4)); // 4
}
