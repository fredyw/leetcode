// https://leetcode.com/problems/minimum-split-into-subarrays-with-gcd-greater-than-one/
pub fn minimum_splits(nums: Vec<i32>) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    let mut gcd = nums[0];
    for i in 1..nums.len() {
        gcd = gcd(gcd, nums[i]);
    }
    gcd
}

fn main() {
    println!("{}", minimum_splits(vec![12, 6, 3, 14, 8])); // 2
    println!("{}", minimum_splits(vec![4, 12, 6, 14])); // 1
}
