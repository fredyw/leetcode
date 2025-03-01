// https://leetcode.com/problems/parallel-courses/
pub fn minimum_semesters(n: i32, relations: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", minimum_semesters(3, vec![vec![1, 3], vec![2, 3]])); // 2
    println!(
        "{}",
        minimum_semesters(3, vec![vec![1, 2], vec![2, 3], vec![3, 1]])
    ); // -1
    println!(
        "{}",
        minimum_semesters(3, vec![vec![1, 2], vec![2, 3], vec![3, 1], vec![4, 1]])
    ); // -1
    println!("{}", minimum_semesters(3, vec![vec![1, 2], vec![2, 3]])); // 3
}
