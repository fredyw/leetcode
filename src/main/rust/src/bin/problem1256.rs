// https://leetcode.com/problems/encode-number/
pub fn encode(num: i32) -> String {
    if num == 0 {
        return "".to_string();
    }
    let mut n = 1;
    let mut i: u32 = 1;
    while n <= num as u64 {
        n += 2_u64.pow(i);
        i += 1;
    }
    let n = n - 2_u64.pow(i - 1);
    let diff = format!("{:b}", num as u64 - n);
    let mut answer = String::new();
    if diff.len() < i as usize - 1 {
        for i in 0..((i as usize - 1) - diff.len()) {
            answer.push('0');
        }
    }
    answer.push_str(&diff);
    answer
}

fn main() {
    println!("{}", encode(0)); // ""
    println!("{}", encode(1)); // "0"
    println!("{}", encode(2)); // "1"
    println!("{}", encode(3)); // "00"
    println!("{}", encode(4)); // "01"
    println!("{}", encode(5)); // "11"
    println!("{}", encode(6)); // "111"
    println!("{}", encode(7)); // "000"
    println!("{}", encode(8)); // "001"
    println!("{}", encode(23)); // "1000"
    println!("{}", encode(107)); // "101100"
    println!("{}", encode(1000000000)); // "11011100110101100101000000001"
    println!("{}", encode(33195842)); // "111110101000011101000011"
}
