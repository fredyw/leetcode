// https://leetcode.com/problems/factor-combinations/description/
pub fn get_factors(n: i32) -> Vec<Vec<i32>> {
    fn factors(n: i32) -> Vec<Vec<i32>> {
        (2..=n.isqrt())
            .filter(|m| n % m == 0)
            .map(|m| vec![m, n / m])
            .collect()
    }

    let mut answer = vec![];
    for v in factors(n).iter() {
        for n in v.iter() {}
    }
    answer
}

fn main() {
    // println!("{:?}", get_factors(1)); // []
    // println!("{:?}", get_factors(12)); // [[2,6],[3,4],[2,2,3]]
    // println!("{:?}", get_factors(37)); // []
    // println!("{:?}", get_factors(24)); // [[2,12],[3,8],[4,6],[2,2,6],[2,3,4],[2,2,2,3]]
    // println!("{:?}", get_factors(4)); // [[2,2]]
    println!("{:?}", get_factors(8)); // [[2,4],[2,2,2]]
}
