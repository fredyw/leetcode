// https://leetcode.com/problems/factor-combinations/description/
pub fn get_factors(n: i32) -> Vec<Vec<i32>> {
    (2..=n.isqrt()).map(|x| vec![x, n / x]).collect()
}

fn main() {
    println!("{:?}", get_factors(1)); // []
    println!("{:?}", get_factors(12)); // [[2,6],[3,4],[2,2,3]]
    println!("{:?}", get_factors(37)); // []
}
