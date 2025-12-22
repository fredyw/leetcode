// https://leetcode.com/problems/find-diameter-endpoints-of-a-tree/description/
pub fn find_special_nodes(n: i32, edges: Vec<Vec<i32>>) -> String {
    todo!()
}

fn main() {
    println!("{}", find_special_nodes(3, vec![vec![0, 1], vec![1, 2]])); // "101"
    println!(
        "{}",
        find_special_nodes(
            7,
            vec![
                vec![0, 1],
                vec![1, 2],
                vec![2, 3],
                vec![3, 4],
                vec![3, 5],
                vec![1, 6]
            ]
        )
    ); // "1000111"
    println!("{}", find_special_nodes(2, vec![vec![0, 1]])); // "11"
}
