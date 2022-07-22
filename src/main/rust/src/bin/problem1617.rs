// https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/
pub fn count_subgraphs_for_each_diameter(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        count_subgraphs_for_each_diameter(4, vec![vec![1, 2], vec![2, 3], vec![2, 4]])
    ); // [3,4,0]
    println!(
        "{:?}",
        count_subgraphs_for_each_diameter(4, vec![vec![1, 2]])
    ); // [1]
    println!(
        "{:?}",
        count_subgraphs_for_each_diameter(4, vec![vec![1, 2], vec![2, 3]])
    ); // [2,1]
}
