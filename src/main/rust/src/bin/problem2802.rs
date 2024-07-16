// https://leetcode.com/problems/find-the-k-th-lucky-number/description/
pub fn kth_lucky_number(k: i32) -> String {
    let mut n = 1;
    let mut kth = 0;
    while kth < k as u32 {
        kth += 2u32.pow(n);
        n += 1;
    }
    kth -= 2u32.pow(n - 1);
    format!("{:0>width$b}", k as u32 - kth - 1, width = n as usize - 1)
        .chars()
        .into_iter()
        .map(|c| if c == '0' { '4' } else { '7' })
        .collect()
}

fn main() {
    println!("{}", kth_lucky_number(4)); // "47"
    println!("{}", kth_lucky_number(6)); // "77"
    println!("{}", kth_lucky_number(10)); // "477"
    println!("{}", kth_lucky_number(20)); // "4747"
    println!("{}", kth_lucky_number(100)); // "744747"
    println!("{}", kth_lucky_number(1000)); // "777747447"
    println!("{}", kth_lucky_number(1000000000)); // "77477744774747744747444444447"
}
