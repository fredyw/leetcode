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
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 0, 1, 1, 1, 3], "abaabcb".to_string())
    ); // [7,4,1,1,1,1,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 1], "aaa".to_string())
    ); // [3,2,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1, 0, 1, 2, 3], "abcbd".to_string())
    ); // [5,4,1,2,1]
    println!(
        "{:?}",
        find_subtree_sizes(vec![-1,0,1,2], "abab".to_string())
    ); // [4,2,1,1]
}
}
