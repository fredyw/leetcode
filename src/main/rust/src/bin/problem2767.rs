// https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings/
pub fn minimum_beautiful_substrings(s: String) -> i32 {
    fn is_power_of_5(n: i32) -> bool {
        let mut x = n;
        while x > 1 && x % 5 == 0 {
            x /= 5;
        }
        x == 1
    }

    fn minimum_beautiful_substrings(chars: &Vec<char>, i: usize, num: i32) -> i32 {
        if i == chars.len() {
            if is_power_of_5(num) {
                return 1;
            }
            return i32::MAX;
        }
        let n = if chars[i] == '0' { 0 } else { 1 };
        let new_num = (num << 1) ^ n;
        if new_num == 0 {
            return i32::MAX;
        }
        let mut min = i32::MAX;
        if is_power_of_5(new_num) {
            let m = minimum_beautiful_substrings(chars, i + 1, 0);
            if m != i32::MAX {
                min = min.min(m + 1);
            }
        }
        let m = minimum_beautiful_substrings(chars, i + 1, new_num);
        if m != i32::MAX {
            min = min.min(m);
        }
        min
    }

    let chars: Vec<char> = s.chars().into_iter().collect();
    let min = minimum_beautiful_substrings(&chars, 0, 0);
    if min == i32::MAX {
        -1
    } else {
        min
    }
}

fn main() {
    println!("{}", minimum_beautiful_substrings("1011".to_string())); // 2
    println!("{}", minimum_beautiful_substrings("111".to_string())); // 3
    println!("{}", minimum_beautiful_substrings("0".to_string())); // -1
    println!(
        "{}",
        minimum_beautiful_substrings("11010101010010".to_string())
    ); // -1
    println!("{}", minimum_beautiful_substrings("0111".to_string())); // -1
    println!(
        "{}",
        minimum_beautiful_substrings("100111000110111".to_string())
    ); // 4
    println!(
        "{}",
        minimum_beautiful_substrings("11110100001001".to_string())
    ); // 1
}
