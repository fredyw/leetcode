// https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/
pub fn value_after_k_seconds(n: i32, k: i32) -> i32 {
    let mut v = vec![1; n as usize];
    for _ in 0..k {
        for i in 1..v.len() {
            v[i] = (v[i - 1] + v[i]) % 1_000_000_007;
        }
    }
    v[v.len() - 1] % 1_000_000_007
}

fn main() {
    println!("{}", value_after_k_seconds(4, 5)); // 56
    println!("{}", value_after_k_seconds(5, 3)); // 35
    println!("{}", value_after_k_seconds(5, 4)); // 70
    println!("{}", value_after_k_seconds(1000, 1000)); // 36237869
}
