// https://leetcode.com/problems/count-nice-pairs-in-an-array/description/
pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
    fn reverse(mut n: i32) -> i32 {
        let mut reversed = 0;
        while n > 0 {
            let m = n % 10;
            reversed = reversed * 10 + m;
            n /= 10;
        }
        reversed
    }

    let mut reversed = vec![];
    for &num in nums.iter() {
        reversed.push(reverse(num));
    }
    let mut answer: i64 = 0;
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            if nums[i] + reversed[j] == reversed[i] + nums[j] {
                answer = (answer + 1) % 1_000_000_007;
            }
        }
    }
    answer as i32
}

fn main() {
    println!("{:?}", count_nice_pairs(vec![42, 11, 1, 97])); // 2
    println!("{:?}", count_nice_pairs(vec![13, 10, 35, 24, 76])); // 4
}
