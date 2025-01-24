// https://leetcode.com/problems/is-array-a-preorder-of-some-binary-tree/description/
pub fn is_preorder(nodes: Vec<Vec<i32>>) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        is_preorder(vec![
            vec![0, -1],
            vec![1, 0],
            vec![2, 0],
            vec![3, 2],
            vec![4, 2]
        ])
    ); // true
    println!(
        "{}",
        is_preorder(vec![
            vec![0, -1],
            vec![1, 0],
            vec![2, 0],
            vec![3, 1],
            vec![4, 1]
        ])
    ); // false
}
