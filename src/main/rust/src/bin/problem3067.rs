// https://leetcode.com/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/description/
pub fn count_pairs_of_connectable_servers(edges: Vec<Vec<i32>>, signal_speed: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        count_pairs_of_connectable_servers(
            vec![
                vec![0, 1, 1],
                vec![1, 2, 5],
                vec![2, 3, 13],
                vec![3, 4, 9],
                vec![4, 5, 2]
            ],
            1
        )
    ); // [0,4,6,6,4,0]
    println!(
        "{:?}",
        count_pairs_of_connectable_servers(
            vec![
                vec![0, 6, 3],
                vec![6, 5, 3],
                vec![0, 3, 1],
                vec![3, 2, 7],
                vec![3, 1, 6],
                vec![3, 4, 2]
            ],
            3
        )
    ); // [2,0,0,0,0,0,2]
    println!(
        "{:?}",
        count_pairs_of_connectable_servers(
            vec![
                vec![0, 1, 1],
                vec![1, 2, 5],
                vec![2, 3, 13],
                vec![3, 4, 9],
                vec![4, 5, 2]
            ],
            2
        )
    ); // [0,0,2,0,2,0]
}
