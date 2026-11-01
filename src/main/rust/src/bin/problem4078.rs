// https://leetcode.com/problems/three-fibonacci-sum/description/
pub fn three_fibonacci_sum(n: i32) -> bool {
    if n % 2 != 0 || n < 2 {
        return false;
    }
    let target = n / 2;
    let mut a = 0;
    let mut b = 1;
    while b < target {
        let next = a + b;
        a = b;
        b = next;
    }
    b == target
}

fn main() {
    println!("{}", three_fibonacci_sum(16)); // true
    println!("{}", three_fibonacci_sum(8)); // false
    println!("{}", three_fibonacci_sum(2)); // true
}
