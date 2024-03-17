// https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/
pub fn sum_of_encrypted_int(nums: Vec<i32>) -> i32 {
    fn max_number(n: i32) -> i32 {
        n.to_string().chars().max().unwrap() as i32 - '0' as i32
    }

    nums.iter()
        .map(|n| {
            let len = n.to_string().len();
            max_number(*n)
                .to_string()
                .repeat(len)
                .parse::<i32>()
                .unwrap()
        })
        .sum()
}

fn main() {
    println!("{}", sum_of_encrypted_int(vec![1, 2, 3])); // 6
    println!("{}", sum_of_encrypted_int(vec![10, 21, 31])); // 66
}
