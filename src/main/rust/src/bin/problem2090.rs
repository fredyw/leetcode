// https://leetcode.com/problems/k-radius-subarray-averages/
pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut answer = vec![-1; nums.len()];
    let length = (k as usize * 2) + 1;
    if nums.len() < length {
        return answer;
    }
    let mut sum: i64 = 0;
    for i in 0..length {
        sum += nums[i] as i64;
    }
    let mut index = k as usize;
    answer[index] = (sum / length as i64) as i32;
    index += 1;
    for i in length..nums.len() {
        sum += nums[i] as i64;
        sum -= nums[i - length] as i64;
        answer[index] = (sum / length as i64) as i32;
        index += 1;
    }
    answer
}

fn main() {
    println!("{:?}", get_averages(vec![7, 4, 3, 9, 1, 8, 5, 2, 6], 3)); // [-1,-1,-1,5,4,4,-1,-1,-1]
    println!("{:?}", get_averages(vec![100000], 0)); // [100000]
    println!("{:?}", get_averages(vec![8], 100000)); // [-1]
}
