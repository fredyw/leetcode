// https://leetcode.com/problems/separate-the-digits-in-an-array/
pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
    nums.into_iter()
        .flat_map(|n| {
            let s = format!("{}", n);
            s.as_bytes()
                .into_iter()
                .map(|b| (*b - '0' as u8) as i32)
                .collect::<Vec<i32>>()
        })
        .collect()
}

fn main() {
    println!("{:?}", separate_digits(vec![13, 25, 83, 77])); // [1,3,2,5,8,3,7,7]
    println!("{:?}", separate_digits(vec![7, 1, 3, 9])); // [7,1,3,9]
}
