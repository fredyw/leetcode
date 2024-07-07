// https://leetcode.com/problems/high-five/description/
pub fn high_five(items: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        high_five(vec![
            vec![1, 91],
            vec![1, 92],
            vec![2, 93],
            vec![2, 97],
            vec![1, 60],
            vec![2, 77],
            vec![1, 65],
            vec![1, 87],
            vec![1, 100],
            vec![2, 100],
            vec![2, 76]
        ])
    ); // [[1,87],[2,88]]
    println!(
        "{:?}",
        high_five(vec![
            vec![1, 100],
            vec![7, 100],
            vec![1, 100],
            vec![7, 100],
            vec![1, 100],
            vec![7, 100],
            vec![1, 100],
            vec![7, 100],
            vec![1, 100],
            vec![7, 100]
        ])
    ); // [[1,100],[7,100]]
}
