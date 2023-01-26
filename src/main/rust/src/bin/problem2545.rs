// https://leetcode.com/problems/sort-the-students-by-their-kth-score/
pub fn sort_the_students(score: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        sort_the_students(
            vec![vec![10, 6, 9, 1], vec![7, 5, 11, 2], vec![4, 8, 3, 15]],
            2
        )
    ); // [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
    println!("{:?}", sort_the_students(vec![vec![3, 4], vec![5, 6]], 0)); // [[5,6],[3,4]]
}
