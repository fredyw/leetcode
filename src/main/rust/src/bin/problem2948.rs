// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
pub fn lexicographically_smallest_array(nums: Vec<i32>, limit: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        lexicographically_smallest_array(vec![1, 5, 3, 9, 8], 2)
    ); // [1,3,5,8,9]
    println!(
        "{:?}",
        lexicographically_smallest_array(vec![1, 7, 6, 18, 2, 1], 3)
    ); // [1,6,7,18,1,2]
    println!(
        "{:?}",
        lexicographically_smallest_array(vec![1, 7, 28, 19, 10], 3)
    ); // [1,7,28,19,10]
}
