// https://leetcode.com/problems/compute-decimal-representation/description/
pub fn decimal_representation(n: i32) -> Vec<i32> {
    let mut answer = vec![];
    let mut n = n;
    let mut exp = format!("{}", n).len() as i32 - 1;
    while n > 0 {
        let d = 10u32.pow(exp as u32);
        let v = (n / d as i32) * d as i32;
        if v > 0 {
            answer.push(v);
        }
        n %= d as i32;
        exp -= 1;
    }
    answer
}

fn main() {
    println!("{:?}", decimal_representation(537)); // [500,30,7]
    println!("{:?}", decimal_representation(102)); // [100,2]
    println!("{:?}", decimal_representation(6)); // [6]
}
