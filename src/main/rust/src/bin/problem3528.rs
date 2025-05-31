// https://leetcode.com/problems/unit-conversion-i/description/
pub fn base_unit_conversions(conversions: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        base_unit_conversions(vec![vec![0, 1, 2], vec![1, 2, 3]])
    ); // [1,2,6]
    println!(
        "{:?}",
        base_unit_conversions(vec![
            vec![0, 1, 2],
            vec![0, 2, 3],
            vec![1, 3, 4],
            vec![1, 4, 5],
            vec![2, 5, 2],
            vec![4, 6, 3],
            vec![5, 7, 4]
        ])
    ); // [1,2,3,8,10,6,30,24]
}
