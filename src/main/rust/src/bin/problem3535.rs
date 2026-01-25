// https://leetcode.com/problems/unit-conversion-ii/description/
pub fn query_conversions(conversions: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        query_conversions(
            vec![vec![0, 1, 2], vec![0, 2, 6]],
            vec![vec![1, 2], vec![1, 0]]
        )
    ); // [3,500000004]
    println!(
        "{:?}",
        query_conversions(
            vec![
                vec![0, 1, 2],
                vec![0, 2, 6],
                vec![0, 3, 8],
                vec![2, 4, 2],
                vec![2, 5, 4],
                vec![3, 6, 3]
            ],
            vec![vec![1, 2], vec![1, 0]]
        )
    ); // [3,12,1,2,83333334]
}
