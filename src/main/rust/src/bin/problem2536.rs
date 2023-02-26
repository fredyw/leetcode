// https://leetcode.com/problems/increment-submatrices-by-one/
pub fn range_add_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        range_add_queries(3, vec![vec![1, 1, 2, 2], vec![0, 0, 1, 1]])
    ); // [[1,1,0],[1,2,1],[0,1,1]]
    println!("{:?}", range_add_queries(2, vec![vec![0, 0, 1, 1]])); // [[1,1],[1,1]]
}
