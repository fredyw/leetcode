// https://leetcode.com/problems/maximum-students-on-a-single-bench/description/
pub fn max_students_on_bench(students: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_students_on_bench(vec![
            vec![1, 2],
            vec![2, 2],
            vec![3, 3],
            vec![1, 3],
            vec![2, 3]
        ])
    ); // 3
    println!(
        "{}",
        max_students_on_bench(vec![
            vec![1, 1],
            vec![2, 1],
            vec![3, 1],
            vec![4, 2],
            vec![5, 2]
        ])
    ); // 3
    println!("{}", max_students_on_bench(vec![vec![1, 1], vec![1, 1]])); // 1
    println!("{}", max_students_on_bench(vec![])); // 0
}
