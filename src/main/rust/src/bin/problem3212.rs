// https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/
pub fn number_of_submatrices(grid: Vec<Vec<char>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        number_of_submatrices(vec![vec!['X', 'Y', '.'], vec!['Y', '.', '.']])
    ); // 3
    println!(
        "{}",
        number_of_submatrices(vec![vec!['X', 'X'], vec!['X', 'Y']])
    ); // 0
    println!(
        "{}",
        number_of_submatrices(vec![vec!['.', '.'], vec!['.', '.']])
    ); // 0
}
