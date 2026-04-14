// https://leetcode.com/problems/find-the-degree-of-each-vertex/description/
pub fn find_degrees(matrix: Vec<Vec<i32>>) -> Vec<i32> {
    let mut answer: Vec<i32> = vec![0; matrix.len()];
    for m in &matrix {
        for (i, v) in m.iter().enumerate() {
            if *v == 1 {
                answer[i] += 1;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        find_degrees(vec![vec![0, 1, 1], vec![1, 0, 1], vec![1, 1, 0]])
    ); // [2,2,2]
    println!(
        "{:?}",
        find_degrees(vec![vec![0, 1, 0], vec![1, 0, 0], vec![0, 0, 0]])
    ); // [1,1,0]
    println!("{:?}", find_degrees(vec![vec![0]])); // [0]
}
