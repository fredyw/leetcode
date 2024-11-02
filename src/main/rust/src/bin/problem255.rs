// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/description/
pub fn verify_preorder(preorder: Vec<i32>) -> bool {
    todo!()
}

fn main() {
    println!("{}", verify_preorder(vec![5, 2, 1, 3, 6])); // true
    println!("{}", verify_preorder(vec![5, 2, 6, 1, 3])); // false
    println!("{}", verify_preorder(vec![1, 2, 3, 4, 5])); // true
}
