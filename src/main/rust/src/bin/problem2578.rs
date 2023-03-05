// https://leetcode.com/problems/split-with-minimum-sum/
pub fn split_num(num: i32) -> i32 {
    let mut nums: Vec<i32> = format!("{}", num)
        .chars()
        .map(|c| (c as u8 - '0' as u8) as i32)
        .collect();
    nums.sort();
    let mut num1 = "".to_string();
    let mut num2 = "".to_string();
    let mut i = 0;
    let mut j = i + 1;
    while i < nums.len() {
        num1.push_str(&format!("{}", nums[i]));
        if j < nums.len() {
            num2.push_str(&format!("{}", nums[j]));
        }
        i += 2;
        j += 2;
    }
    let num1: i32 = num1.parse().unwrap();
    let num2: i32 = num2.parse().unwrap();
    num1 + num2
}

fn main() {
    println!("{}", split_num(4325)); // 49
    println!("{}", split_num(687)); // 75
    println!("{}", split_num(123769)); // 406
    println!("{}", split_num(1237699)); // 1648
}
