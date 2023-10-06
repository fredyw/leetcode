// https://leetcode.com/problems/happy-students/description/
pub fn count_ways(mut nums: Vec<i32>) -> i32 {
    nums.sort();
    let mut answer = 0;
    for (i, n) in nums.iter().enumerate() {
        if *n < (i + 1) as i32 {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", count_ways(vec![1, 1])); // 2
    println!("{}", count_ways(vec![6, 0, 3, 3, 6, 7, 2, 7])); // 3
    println!("{}", count_ways(vec![1, 1, 0, 1])); // 1
    println!("{}", count_ways(vec![2, 3, 3, 3, 3, 3])); // 2
}
