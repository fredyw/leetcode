// https://leetcode.com/problems/increment-submatrices-by-one/
pub fn range_add_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let mut answer = vec![vec![0; n as usize]; n as usize];
    for query in queries.into_iter() {
        let row1 = query[0];
        let col1 = query[1];
        let row2 = query[2];
        let col2 = query[3];
        for r in row1..=row2 {
            for c in col1..=col2 {
                answer[r as usize][c as usize] += 1;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        range_add_queries(3, vec![vec![1, 1, 2, 2], vec![0, 0, 1, 1]])
    ); // [[1,1,0],[1,2,1],[0,1,1]]
    println!("{:?}", range_add_queries(2, vec![vec![0, 0, 1, 1]])); // [[1,1],[1,1]]
}
