// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/
pub fn are_similar(mat: Vec<Vec<i32>>, k: i32) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        are_similar(
            vec![vec![1, 2, 1, 2], vec![5, 5, 5, 5], vec![6, 3, 6, 3]],
            2
        )
    ); // true
    println!("{}", are_similar(vec![vec![2, 2], vec![2, 2]], 3)); // true
    println!("{}", are_similar(vec![vec![1, 2]], 1)); // false
}
