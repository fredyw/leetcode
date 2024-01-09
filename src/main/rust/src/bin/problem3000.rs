// https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/
pub fn area_of_max_diagonal(dimensions: Vec<Vec<i32>>) -> i32 {
    let mut answer = 0;
    let mut longest_diagonal = 0f64;
    for dimension in dimensions.iter() {
        let length = dimension[0];
        let width = dimension[1];
        let diagonal = ((length * length + width * width) as f64).sqrt();
        if diagonal > longest_diagonal {
            longest_diagonal = diagonal;
            answer = length * width;
        } else if diagonal == longest_diagonal {
            answer = answer.max(length * width);
        }
    }
    answer
}

fn main() {
    println!("{}", area_of_max_diagonal(vec![vec![9, 3], vec![8, 6]])); // 48
    println!("{}", area_of_max_diagonal(vec![vec![3, 4], vec![4, 3]])); // 12
    println!(
        "{}",
        area_of_max_diagonal(vec![
            vec![6, 5],
            vec![8, 6],
            vec![2, 10],
            vec![8, 1],
            vec![9, 2],
            vec![3, 5],
            vec![3, 5]
        ])
    ); // 20
}
