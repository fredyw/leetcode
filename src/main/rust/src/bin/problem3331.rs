// https://leetcode.com/problems/find-subtree-sizes-after-changes/
pub fn find_subtree_sizes(parent: Vec<i32>, s: String) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 0, 1, 1, 1], "abaabc".to_string())
    ); // [6,3,1,1,1,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 4, 0, 1], "abbba".to_string())
    ); // [5,2,1,1,1]
}
