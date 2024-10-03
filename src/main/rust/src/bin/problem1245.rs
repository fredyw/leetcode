// https://leetcode.com/problems/tree-diameter/description/
pub fn tree_diameter(edges: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", tree_diameter(vec![vec![0, 1], vec![0, 2]])); // 2
    println!(
        "{}",
        tree_diameter(vec![
            vec![0, 1],
            vec![1, 2],
            vec![2, 3],
            vec![1, 4],
            vec![4, 5]
        ])
    ); // 4
}
