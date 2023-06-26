// https://leetcode.com/problems/number-of-beautiful-pairs/
pub fn count_beautiful_pairs(nums: Vec<i32>) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    todo!()
}

fn main() {
    println!("{}", count_beautiful_pairs(vec![2, 5, 1, 4])); // 5
    println!("{}", count_beautiful_pairs(vec![11, 21, 12])); // 2
}
