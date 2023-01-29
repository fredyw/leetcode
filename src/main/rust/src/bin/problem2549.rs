// https://leetcode.com/problems/count-distinct-numbers-on-board/
pub fn distinct_integers(n: i32) -> i32 {
    if n == 1 {
        1
    } else {
        n - 1
    }
}

fn main() {
    println!("{}", distinct_integers(5)); // 4
    println!("{}", distinct_integers(3)); // 2
}
