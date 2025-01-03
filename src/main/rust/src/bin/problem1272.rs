// https://leetcode.com/problems/remove-interval/description/
pub fn remove_interval(intervals: Vec<Vec<i32>>, to_be_removed: Vec<i32>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        remove_interval(vec![vec![0, 2], vec![3, 4], vec![5, 7]], vec![1, 6])
    ); // [[0,1],[6,7]]
    println!("{:?}", remove_interval(vec![vec![0, 5]], vec![2, 3])); // [[0,2],[3,5]]
    println!(
        "{:?}",
        remove_interval(
            vec![
                vec![-5, -4],
                vec![-3, -2],
                vec![1, 2],
                vec![3, 5],
                vec![8, 9]
            ],
            vec![-1, 4]
        )
    ); // [[-5,-4],[-3,-2],[4,5],[8,9]]
}
