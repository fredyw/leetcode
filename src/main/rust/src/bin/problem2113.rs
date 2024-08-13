// https://leetcode.com/problems/elements-in-array-after-removing-and-replacing-elements/description/
pub fn element_in_nums(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        element_in_nums(
            vec![0, 1, 2],
            vec![vec![0, 2], vec![2, 0], vec![3, 2], vec![5, 0]]
        )
    ); // [2,2,-1,0]
    println!(
        "{:?}",
        element_in_nums(
            vec![2],
            vec![vec![0, 0], vec![1, 0], vec![2, 0], vec![3, 0]]
        )
    ); // [2,-1,2,-1]
}
