// https://leetcode.com/problems/minimum-number-of-flips-to-reverse-binary-string/description/
pub fn minimum_flips(n: i32) -> i32 {
    let n = n as u32;
    let m = n.reverse_bits() >> n.leading_zeros();
    let x = m ^ n;
    x.count_ones() as i32
}

fn main() {
    println!("{}", minimum_flips(7)); // 0
    println!("{}", minimum_flips(10)); // 4
}
