// https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings/
pub fn minimum_beautiful_substrings(s: String) -> i32 {
    fn is_power_of_5(n: u32) -> bool {
        if n == 0 {
            return false;
        }
        if n == 1 {
            return true;
        }
        let p = f32::powf(n as f32, 1.0 / 5.0);
        5u32.pow(p as u32) == n
    }

    todo!()
}

fn main() {
    // println!("{}", minimum_beautiful_substrings("1011".to_string())); // 2
    // println!("{}", minimum_beautiful_substrings("111".to_string())); // 3
    // println!("{}", minimum_beautiful_substrings("0".to_string())); // -1
}
