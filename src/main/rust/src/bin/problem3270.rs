// https://leetcode.com/problems/find-the-key-of-the-numbers/description/
pub fn generate_key(num1: i32, num2: i32, num3: i32) -> i32 {
    let mut answer = String::new();
    let num1 = format!("{:04}", num1);
    let num1 = num1.as_bytes();
    let num2 = format!("{:04}", num2);
    let num2 = num2.as_bytes();
    let num3 = format!("{:04}", num3);
    let num3 = num3.as_bytes();
    for i in 0..4 {
        let min = num1[i].min(num2[i].min(num3[i])) - '0' as u8;
        answer.push_str(&min.to_string());
    }
    answer.parse().unwrap()
}

fn main() {
    println!("{}", generate_key(1, 10, 1000)); // 0
    println!("{}", generate_key(987, 879, 798)); // 777
    println!("{}", generate_key(1, 2, 3)); // 1
}
