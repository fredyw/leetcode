// https://leetcode.com/problems/design-neighbor-sum-service/
struct NeighborSum {}

impl NeighborSum {
    fn new(grid: Vec<Vec<i32>>) -> Self {
        NeighborSum {}
    }

    fn adjacent_sum(&self, value: i32) -> i32 {
        todo!()
    }

    fn diagonal_sum(&self, value: i32) -> i32 {
        todo!()
    }
}

fn main() {
    let neighbor_sum = NeighborSum::new(vec![vec![0, 1, 2], vec![3, 4, 5], vec![6, 7, 8]]);
    println!("{}", neighbor_sum.adjacent_sum(1)); // 6
    println!("{}", neighbor_sum.adjacent_sum(4)); // 16
    println!("{}", neighbor_sum.diagonal_sum(4)); // 16
    println!("{}", neighbor_sum.diagonal_sum(8)); // 4

    let neighbor_sum = NeighborSum::new(vec![
        vec![1, 2, 0, 3],
        vec![4, 7, 15, 6],
        vec![8, 9, 10, 11],
        vec![12, 13, 14, 5],
    ]);
    println!("{}", neighbor_sum.adjacent_sum(15)); // 23
    println!("{}", neighbor_sum.diagonal_sum(9)); // 45
}
