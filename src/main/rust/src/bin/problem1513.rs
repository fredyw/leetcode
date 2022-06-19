// https://leetcode.com/problems/number-of-substrings-with-only-1s/
pub fn num_sub(s: String) -> i32 {
    fn f(length: usize) -> i64 {
        let mut sum: i64 = 0;
        for i in 1..=length {
            sum += i as i64
        }
        sum
    }
    let mut answer = 0;
    let chars: Vec<char> = s.chars().collect();
    let mut length = 0;
    let mut i = 0;
    while i < chars.len() - 1 {
        if chars[i] == '1' && chars[i + 1] != '1' {
            length += 1;
            answer += f(length);
            length = 0;
        } else if chars[i] == '1' && chars[i + 1] == '1' {
            length += 1;
        } else {
            length = 0;
        }
        i += 1;
    }
    if chars[i] == '1' {
        length += 1;
    }
    answer += f(length);
    (answer % 1_000_000_007) as i32
}

fn main() {
    println!("{}", num_sub(String::from("0110111"))); // 9
    println!("{}", num_sub(String::from("101"))); // 2
    println!("{}", num_sub(String::from("111111"))); // 21
    println!("{}", num_sub(String::from("1111110"))); // 21
    println!("{}", num_sub(String::from("11111101"))); // 22
    println!("{}", num_sub(String::from("1010"))); // 2
}
