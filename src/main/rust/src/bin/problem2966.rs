//https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
pub fn divide_array(nums: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!("{:?}", divide_array(vec![1, 3, 4, 8, 7, 9, 3, 5, 1], 2)); // [[1,1,3],[3,4,5],[7,8,9]]
    println!("{:?}", divide_array(vec![1, 3, 3, 2, 7, 3], 3)); // []
    println!("{:?}", divide_array(vec![1, 2, 3], 1)); // []
    println!("{:?}", divide_array(vec![1, 2, 2], 1)); // [[1],[2],[2]]]
}
