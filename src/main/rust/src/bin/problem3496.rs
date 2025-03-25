// https://leetcode.com/problems/maximize-score-after-pair-deletions/
pub fn max_score(nums: Vec<i32>) -> i32 {
    let mut answer = nums.iter().sum::<i32>();
    if nums.len() % 2 == 0 {
        let mut min = i32::MAX;
        for i in 0..nums.len() - 1 {
            let n = nums[i] + nums[i + 1];
            min = min.min(n);
        }
        answer -= min;
    } else {
        let min = *nums.iter().min().unwrap();
        answer -= min;
    }
    answer
}

fn main() {
    println!("{}", max_score(vec![2, 4, 1])); // 6
    println!("{}", max_score(vec![5, -1, 4, 2])); // 7
    println!(
        "{}",
        max_score(vec![8059, -2702, -8432, 846, -1793, -8320, 6115, 1853])
    ); // 6760
}
