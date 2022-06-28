// https://leetcode.com/problems/maximum-xor-after-operations/
pub fn maximum_xor(nums: Vec<i32>) -> i32 {
    fn get_nth_bit(i: i32, n: i32) -> i32 {
        (i >> n) & 1
    }

    fn set_nth_bit(i: i32, n: i32) -> i32 {
        (1 << n) | i
    }

    let mut xor = 0;
    for num in nums.iter() {
        xor ^= *num;
    }
    let mut answer = xor;
    for n in 0..32 {
        let mut sum = 0;
        for num in nums.iter() {
            sum += get_nth_bit(*num, n);
        }
        if sum != 0 && sum % 2 == 0 {
            answer = set_nth_bit(answer, n);
        }
    }
    answer
}

fn main() {
    println!("{}", maximum_xor(vec![3, 2, 4, 6])); // 7
    println!("{}", maximum_xor(vec![1, 2, 3, 9, 2])); // 11
    println!("{}", maximum_xor(vec![1, 2, 3, 9])); // 11
    println!("{}", maximum_xor(vec![1, 2, 3, 9, 9, 9])); // 11
    println!(
        "{}",
        maximum_xor(vec![
            1, 2, 3, 9, 2, 8784, 3223, 456, 234, 587, 4535, 12353, 456
        ])
    ); // 16383
}
