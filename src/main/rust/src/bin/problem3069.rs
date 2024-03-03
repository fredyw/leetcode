// https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/
pub fn result_array(nums: Vec<i32>) -> Vec<i32> {
    let mut arr1 = vec![];
    let mut arr2 = vec![];
    arr1.push(nums[0]);
    arr2.push(nums[1]);
    let mut i = 2;
    while i < nums.len() {
        if arr1[arr1.len() - 1] > arr2[arr2.len() - 1] {
            arr1.push(nums[i]);
        } else {
            arr2.push(nums[i]);
        }
        i += 1;
    }
    arr1.append(&mut arr2);
    arr1
}

fn main() {
    println!("{:?}", result_array(vec![2, 1, 3])); // [2,3,1]
    println!("{:?}", result_array(vec![5, 4, 3, 8])); // [5,3,4,8]
}
