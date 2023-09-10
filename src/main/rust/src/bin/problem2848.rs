// https://leetcode.com/problems/points-that-intersect-with-cars/
pub fn number_of_points(mut nums: Vec<Vec<i32>>) -> i32 {
    nums.sort_by(|a, b| (a[0], a[1]).cmp(&(b[0], b[1])));
    let mut answer = nums[0][1] - nums[0][0] + 1;
    let mut prev_end = nums[0][1];
    for i in 1..nums.len() {
        if prev_end >= nums[i][0] {
            if prev_end < nums[i][1] {
                answer += nums[i][1] - prev_end;
            }
        } else {
            answer += nums[i][1] - nums[i][0] + 1;
        }
        prev_end = prev_end.max(nums[i][1]);
    }
    answer
}

fn main() {
    println!(
        "{}",
        number_of_points(vec![vec![3, 6], vec![1, 5], vec![4, 7]])
    ); // 7
    println!("{}", number_of_points(vec![vec![1, 3], vec![5, 8]])); // 7
    println!(
        "{}",
        number_of_points(vec![vec![3, 4], vec![1, 5], vec![4, 7]])
    ); // 7
    println!(
        "{}",
        number_of_points(vec![vec![1, 2], vec![3, 5], vec![10, 12], vec![40, 60]])
    ); // 29
}
