// https://leetcode.com/problems/hexadecimal-and-hexatrigesimal-conversion/description/
pub fn concat_hex36(n: i32) -> String {
    fn to_hexa(mut n: u64, base: u64) -> String {
        if n == 0 {
            return "0".to_string();
        }
        let mut result = String::new();
        let chars: Vec<char> = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".chars().collect();
        while n > 0 {
            let remainder = (n % base) as usize;
            result.push(chars[remainder]);
            n /= base;
        }
        result.chars().rev().collect()
    }

    let n = n as u64;
    format!("{}{}", to_hexa(n * n, 16), to_hexa(n * n * n, 36))
}

fn main() {
    println!("{}", concat_hex36(13)); // "A91P1"
    println!("{}", concat_hex36(36)); // "5101000"
    println!("{}", concat_hex36(11)); // "7910Z"
    println!("{}", concat_hex36(1000)); // "F4240GJDGXS"
}
