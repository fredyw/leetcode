// https://leetcode.com/problems/merge-similar-items/
pub fn merge_similar_items(items1: Vec<Vec<i32>>, items2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{}",
        merge_similar_items(
            vec![vec![1, 1], vec![4, 5], vec![3, 8]],
            vec![vec![3, 1], vec![1, 5]]
        )
    ); // [[1,6],[3,9],[4,5]]
    println!(
        "{}",
        merge_similar_items(
            vec![vec![1, 1], vec![3, 2], vec![2, 3]],
            vec![vec![2, 1], vec![3, 2], vec![1, 3]]
        )
    ); // [[1,4],[2,4],[3,4]]
    println!(
        "{}",
        merge_similar_items(
            vec![vec![1, 3], vec![2, 2]],
            vec![vec![7, 1], vec![2, 2], vec![1, 4]]
        )
    ); // [[1,7],[2,4],[7,1]]
}
