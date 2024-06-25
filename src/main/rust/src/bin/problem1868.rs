// https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/description/
pub fn find_rle_array(encoded1: Vec<Vec<i32>>, encoded2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        find_rle_array(vec![vec![1, 3], vec![2, 3]], vec![vec![6, 3], vec![3, 3]])
    ); // [[6,6]]
    println!(
        "{:?}",
        find_rle_array(
            vec![vec![1, 3], vec![2, 1], vec![3, 2]],
            vec![vec![2, 3], vec![3, 3]]
        )
    ); // [[2,3],[6,1],[9,2]]
}
