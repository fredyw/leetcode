// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
pub fn count_sub_trees(n: i32, edges: Vec<Vec<i32>>, labels: String) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        count_sub_trees(
            7,
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![1, 4],
                vec![1, 5],
                vec![2, 3],
                vec![2, 6]
            ],
            "abaedcd".to_string()
        )
    ); //
    println!(
        "{:?}",
        count_sub_trees(
            4,
            vec![vec![0, 1], vec![1, 2], vec![0, 3]],
            "bbbb".to_string()
        )
    ); // [4,2,1,1]
    println!(
        "{:?}",
        count_sub_trees(
            5,
            vec![vec![0, 1], vec![0, 2], vec![1, 3], vec![0, 4]],
            "aabab".to_string()
        )
    ); // [3,2,1,1,1]
}
