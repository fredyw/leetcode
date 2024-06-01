// https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/
pub fn occurrences_of_element(nums: Vec<i32>, queries: Vec<i32>, x: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        occurrences_of_element(vec![1, 3, 1, 7], vec![1, 3, 2, 4], 1)
    ); // [0,-1,2,-1]
    println!("{:?}", occurrences_of_element(vec![1, 2, 3], vec![10], 5)); // [-1]
}
