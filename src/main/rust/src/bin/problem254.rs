// https://leetcode.com/problems/factor-combinations/description/
pub fn get_factors(n: i32) -> Vec<Vec<i32>> {
    fn get_factors(factors: &mut Vec<i32>, answer: &mut Vec<Vec<i32>>) {
        if factors.len() > 1 {
            answer.push(factors.clone());
        }
        let last_factor = factors.pop().unwrap();
        for i in *factors.last().unwrap_or(&2)..=last_factor.isqrt() {
            if last_factor % i == 0 {
                factors.push(i);
                factors.push(last_factor / i);
                get_factors(factors, answer);
                factors.pop();
                factors.pop();
            }
        }
        factors.push(last_factor);
    }

    let mut answer = vec![];
    get_factors(&mut vec![n], &mut answer);
    answer
}

fn main() {
    println!("{:?}", get_factors(1)); // []
    println!("{:?}", get_factors(12)); // [[2,6],[3,4],[2,2,3]]
    println!("{:?}", get_factors(37)); // []
    println!("{:?}", get_factors(24)); // [[2,12],[3,8],[4,6],[2,2,6],[2,3,4],[2,2,2,3]]
    println!("{:?}", get_factors(4)); // [[2,2]]
    println!("{:?}", get_factors(8)); // [[2,4],[2,2,2]]
}
