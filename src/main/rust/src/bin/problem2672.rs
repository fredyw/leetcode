// https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/
pub fn color_the_array(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        color_the_array(
            4,
            vec![vec![0, 2], vec![1, 2], vec![3, 1], vec![1, 1], vec![2, 1]]
        )
    ); // [0,1,1,0,2]
    println!("{:?}", color_the_array(1, vec![vec![0, 100000]])); // [0]
}
