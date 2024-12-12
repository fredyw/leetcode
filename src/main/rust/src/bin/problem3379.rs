// https://leetcode.com/problems/transformed-array/description/
pub fn construct_transformed_array(nums: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![];
    for (i, num) in nums.iter().enumerate() {
        let index =
            ((i as i32 + *num) % nums.len() as i32 + nums.len() as i32) as usize % nums.len();
        answer.push(nums[index]);
    }
    answer
}

fn main() {
    println!("{:?}", construct_transformed_array(vec![3, -2, 1, 1])); // [1,1,1,3]
    println!("{:?}", construct_transformed_array(vec![-1, 4, -1])); // [-1,-1,4]
    println!("{:?}", construct_transformed_array(vec![-10, -10, -4])); // [-4,-10,-10]
}
