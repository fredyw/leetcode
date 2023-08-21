// https://leetcode.com/problems/detonate-the-maximum-bombs/
pub fn maximum_detonation(bombs: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", maximum_detonation(vec![vec![2, 1, 3], vec![6, 1, 4]])); // 2
    println!(
        "{}",
        maximum_detonation(vec![vec![1, 1, 5], vec![10, 10, 5]])
    ); // 1
    println!(
        "{}",
        maximum_detonation(vec![
            vec![1, 2, 3],
            vec![2, 3, 1],
            vec![3, 4, 2],
            vec![4, 5, 3],
            vec![5, 6, 4]
        ])
    ); // 5
}
