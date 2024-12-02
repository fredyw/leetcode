// https://leetcode.com/problems/smallest-number-with-all-set-bits/description/
pub fn smallest_number(n: i32) -> i32 {
    let bin = format!("{:0b}", n);
    if bin.chars().all(|c| c == '1') {
        return n;
    }
    let bin: String = bin.chars().map(|_| '1').collect();
    i32::from_str_radix(&bin, 2).unwrap()
}

fn main() {
    println!("{}", smallest_number(5)); // 7
    println!("{}", smallest_number(10)); // 15
    println!("{}", smallest_number(3)); // 3
}
