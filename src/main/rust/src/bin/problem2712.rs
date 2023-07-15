// https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal/
pub fn minimum_cost(s: String) -> i64 {
    fn cost(chars: &Vec<char>, c: char) -> i64 {
        let mut total_count: i64 = 0;
        let mid = chars.len() / 2;
        let mut count = 0;
        for i in (0..mid).rev() {
            if (count % 2 == 0 && chars[i] != c) || (count % 2 != 0 && chars[i] == c) {
                count += 1;
                total_count += i as i64 + 1;
            }
        }
        let mut count = 0;
        for i in mid..chars.len() {
            if (count % 2 == 0 && chars[i] != c) || (count % 2 != 0 && chars[i] == c) {
                count += 1;
                total_count += chars.len() as i64 - i as i64;
            }
        }
        total_count
    }

    let chars = s.chars().collect::<Vec<char>>();
    let try_zero = cost(&chars, '0');
    let try_one = cost(&chars, '1');
    try_zero.min(try_one)
}

fn main() {
    println!("{}", minimum_cost("0011".to_string())); // 2
    println!("{}", minimum_cost("010101".to_string())); // 9
    println!("{}", minimum_cost("101101".to_string())); // 6
    println!("{}", minimum_cost("10010110".to_string())); // 12
    println!("{}", minimum_cost("1010101101110001".to_string())); // 41
    println!("{}", minimum_cost("101011101110001".to_string())); // 29
}
