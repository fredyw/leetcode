// https://leetcode.com/problems/find-the-maximum-divisibility-score/
pub fn max_div_score(nums: Vec<i32>, divisors: Vec<i32>) -> i32 {
    let mut answer = i32::MAX;
    let mut max_score = 0;
    for divisor in divisors.iter() {
        let mut count = 0;
        for num in nums.iter() {
            if num % divisor == 0 {
                count += 1;
            }
        }
        if count > max_score {
            max_score = count;
            answer = *divisor;
        } else if max_score == count {
            answer = answer.min(*divisor);
        }
    }
    answer
}

fn main() {
    println!("{}", max_div_score(vec![4, 7, 9, 3, 9], vec![5, 2, 3])); // 3
    println!("{}", max_div_score(vec![4, 7, 9, 3], vec![5, 2, 3])); // 3
    println!("{}", max_div_score(vec![20, 14, 21, 10], vec![5, 7, 5])); // 5
    println!("{}", max_div_score(vec![12], vec![10, 16])); // 10
    println!(
        "{}",
        max_div_score(
            vec![
                56, 22, 79, 41, 8, 39, 81, 59, 74, 14, 45, 49, 15, 10, 28, 16, 77, 22, 65, 8, 36,
                79, 94, 44, 80, 72, 8, 96, 78
            ],
            vec![
                39, 92, 69, 55, 9, 44, 26, 76, 40, 77, 16, 69, 40, 64, 12, 48, 66, 7, 59, 10, 33,
                72, 97, 60, 79, 68, 25, 63
            ]
        )
    ); // 7
}
