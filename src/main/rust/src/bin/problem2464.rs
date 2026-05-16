// https://leetcode.com/problems/minimum-subarrays-in-a-valid-split/description/
pub fn valid_subarray_split(nums: Vec<i32>) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            return a;
        }
        gcd(b, a / b)
    }
    todo!()
}

fn main() {
    println!("{}", valid_subarray_split(vec![2, 6, 3, 4, 3])); // 2
    println!("{}", valid_subarray_split(vec![3, 5])); // 2
    println!("{}", valid_subarray_split(vec![1, 2, 1])); // -1
}
