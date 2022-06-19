// https://leetcode.com/problems/k-th-smallest-prime-fraction/
pub fn kth_smallest_prime_fraction(arr: Vec<i32>, k: i32) -> Vec<i32> {
    struct Fraction(i32, i32);
    let mut fractions: Vec<Fraction> = vec![];
    for i in 0..arr.len() {
        for j in i + 1..arr.len() {
            fractions.push(Fraction(arr[i], arr[j]));
        }
    }
    fractions.sort_by(|a, b| {
        (a.0 as f64 / a.1 as f64)
            .partial_cmp(&(b.0 as f64 / b.1 as f64))
            .unwrap()
    });
    let answer = &fractions[(k - 1) as usize];
    vec![answer.0, answer.1]
}

fn main() {
    println!("{:?}", kth_smallest_prime_fraction(vec![1, 2, 3, 5], 3)); // [2,5]
    println!("{:?}", kth_smallest_prime_fraction(vec![1, 7], 1)); // [1,7]
}
