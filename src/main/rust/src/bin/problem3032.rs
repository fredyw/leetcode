// https://leetcode.com/problems/count-numbers-with-unique-digits-ii/description/
pub fn number_count(a: i32, b: i32) -> i32 {
    let mut answer = 0;
    for i in a..=b {
        let mut nums = vec![false; 10];
        let mut has_duplicate = false;
        for c in format!("{i}").chars() {
            if nums[c as usize - '0' as usize] {
                has_duplicate = true;
                break;
            }
            nums[c as usize - '0' as usize] = true;
        }
        if !has_duplicate {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", number_count(1, 20)); // 19
    println!("{}", number_count(9, 19)); // 10
    println!("{}", number_count(80, 120)); // 27
}
