// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
pub fn punishment_number(n: i32) -> i32 {
    fn is_punishment_number(num: i32, chars: &Vec<char>, i: usize, acc: i32, s: String) -> bool {
        let sum = s.parse::<i32>().unwrap_or(0);
        if sum > num {
            return false;
        }
        if i == chars.len() {
            return acc + sum == num;
        }
        let n = chars[i] as i32 - '0' as i32;
        if is_punishment_number(num, chars, i + 1, acc + sum, n.to_string()) {
            return true;
        }
        if is_punishment_number(num, chars, i + 1, acc, s + &n.to_string()) {
            return true;
        }
        false
    }

    let mut answer = 0;
    for i in 1..=n {
        let chars: Vec<char> = (i * i).to_string().chars().collect();
        if is_punishment_number(i, &chars, 0, 0, String::new()) {
            answer += i * i;
        }
    }
    answer
}

fn main() {
    println!("{}", punishment_number(10)); // 182
    println!("{}", punishment_number(37)); // 1478
}
