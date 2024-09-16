// https://leetcode.com/problems/minimum-split-into-subarrays-with-gcd-greater-than-one/
pub fn minimum_splits(nums: Vec<i32>) -> i32 {
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            gcd(b, a % b)
        }
    }

    let mut answer = 1;
    let mut g = nums[0];
    for i in 1..nums.len() {
        g = gcd(g, nums[i]);
        if g == 1 {
            g = nums[i];
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", minimum_splits(vec![12, 6, 3, 14, 8])); // 2
    println!("{}", minimum_splits(vec![4, 12, 6, 14])); // 1
    println!("{}", minimum_splits(vec![3])); // 1
    println!("{}", minimum_splits(vec![2, 3, 4, 5, 6, 7, 8])); // 7
}
