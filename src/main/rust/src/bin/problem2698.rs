// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
pub fn punishment_number(n: i32) -> i32 {
    fn is_punishment_number(num: i32, chars: &Vec<char>, i: usize, acc: i32, sum: i32) -> bool {
        if sum > num {
            return false;
        }
        if i == chars.len() {
            return acc + sum == num;
        }
        let n = chars[i] as i32 - '0' as i32;
        if is_punishment_number(num, chars, i + 1, acc + sum, n) {
            return true;
        }
        if is_punishment_number(num, chars, i + 1, acc, sum * 10 + n) {
            return true;
        }
        false
    }

    let mut answer = 0;
    for i in 1..=n {
        let chars: Vec<char> = (i * i).to_string().chars().collect();
        if is_punishment_number(i, &chars, 0, 0, 0) {
            answer += i * i;
        }
    }
    answer
}

fn main() {
    println!("{}", punishment_number(10)); // 182
    println!("{}", punishment_number(37)); // 1478
}
