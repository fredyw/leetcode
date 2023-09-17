// https://leetcode.com/problems/semi-ordered-permutation/
pub fn semi_ordered_permutation(mut nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let min = 1;
    let max = nums.len() as i32;
    let mut i: i32 = 0;
    while i < nums.len() as i32 {
        if nums[i as usize] == min {
            break;
        }
        i += 1;
    }
    while i - 1 >= 0 {
        nums.swap(i as usize, i as usize - 1);
        i -= 1;
        answer += 1;
    }
    let mut i = 0;
    while i < nums.len() {
        if nums[i] == max {
            break;
        }
        i += 1;
    }
    while i + 1 < nums.len() {
        nums.swap(i, i + 1);
        i += 1;
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", semi_ordered_permutation(vec![2, 1, 4, 3])); // 2
    println!("{}", semi_ordered_permutation(vec![2, 4, 1, 3])); // 3
    println!("{}", semi_ordered_permutation(vec![1, 3, 4, 2, 5])); // 0
}
