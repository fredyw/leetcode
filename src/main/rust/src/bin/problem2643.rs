// https://leetcode.com/problems/row-with-maximum-ones/
pub fn row_and_maximum_ones(mat: Vec<Vec<i32>>) -> Vec<i32> {
    let mut answer = vec![0; 2];
    let mut max_row = 0;
    let mut max_count = 0;
    for i in 0..mat.len() {
        let mut count = 0;
        for j in 0..mat[i].len() {
            if mat[i][j] == 1 {
                count += 1;
            }
        }
        if max_count < count {
            max_count = count;
            max_row = i as i32;
        }
    }
    answer[0] = max_row;
    answer[1] = max_count;
    answer
}

fn main() {
    println!("{:?}", row_and_maximum_ones(vec![vec![0, 1], vec![1, 0]])); // [0,1]
    println!(
        "{:?}",
        row_and_maximum_ones(vec![vec![0, 0, 0], vec![0, 1, 1]])
    ); // [1,2]
    println!(
        "{:?}",
        row_and_maximum_ones(vec![vec![0, 0], vec![1, 1], vec![0, 0]])
    ); // [1,2]
}
