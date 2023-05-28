// https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals/
pub fn difference_of_distinct_values(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        difference_of_distinct_values(vec![vec![1, 2, 3], vec![3, 1, 5], vec![3, 2, 1]])
    ); // [[1,1,0],[1,0,1],[0,1,1]]
    println!("{:?}", difference_of_distinct_values(vec![vec![1]])); // [[0]]
}
