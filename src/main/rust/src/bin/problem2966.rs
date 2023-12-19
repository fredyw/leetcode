// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
pub fn divide_array(mut nums: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
    nums.sort();
    let mut answer = vec![];
    let mut i = 0;
    while i < nums.len() {
        if (nums[i] - nums[i + 1]).abs() <= k
            && (nums[i] - nums[i + 2]).abs() <= k
            && (nums[i + 1] - nums[i + 2]).abs() <= k
        {
            answer.push(vec![nums[i], nums[i + 1], nums[i + 2]]);
        } else {
            return vec![];
        }
        i += 3;
    }
    answer
}

fn main() {
    println!("{:?}", divide_array(vec![1, 3, 4, 8, 7, 9, 3, 5, 1], 2)); // [[1,1,3],[3,4,5],[7,8,9]]
    println!("{:?}", divide_array(vec![1, 3, 3, 2, 7, 3], 3)); // []
    println!("{:?}", divide_array(vec![1, 2, 3], 1)); // []
    println!("{:?}", divide_array(vec![1, 2, 2], 1)); // [[1,2,2]]
    println!("{:?}", divide_array(vec![1, 2, 2, 3, 3, 4], 1)); // [[1,2,2],[3,3,4]]
}
