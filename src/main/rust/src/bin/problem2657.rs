// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
pub fn find_the_prefix_common_array(a: Vec<i32>, b: Vec<i32>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        find_the_prefix_common_array(vec![1, 3, 2, 4], vec![3, 1, 2, 4])
    ); // [0,2,3,4]
    println!(
        "{:?}",
        find_the_prefix_common_array(vec![2, 3, 1], vec![3, 1, 2])
    ); // [0,1,3]
}
