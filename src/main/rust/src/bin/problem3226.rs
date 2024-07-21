// https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/
pub fn min_changes(mut n: i32, k: i32) -> i32 {
    let mut answer = 0;
    let mut shift = 0;
    while n != k {
        if (n >> shift) & 1 != (k >> shift) & 1 {
            if (n >> shift) & 1 == 0 {
                return -1;
            }
            n = !n;
            n |= 1 << shift;
            n = !n;
            answer += 1;
        }
        shift += 1;
    }
    answer
}

fn main() {
    println!("{}", min_changes(13, 4)); // 2
    println!("{}", min_changes(21, 21)); // 0
    println!("{}", min_changes(14, 13)); // -1
}
