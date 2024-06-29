// https://leetcode.com/problems/intersection-of-three-sorted-arrays/description/
pub fn arrays_intersection(arr1: Vec<i32>, arr2: Vec<i32>, arr3: Vec<i32>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        arrays_intersection(
            vec![1, 2, 3, 4, 5],
            vec![1, 2, 5, 7, 9],
            vec![1, 3, 4, 5, 8]
        )
    ); // [1,5]
    println!(
        "{:?}",
        arrays_intersection(
            vec![197, 418, 523, 876, 1356],
            vec![501, 880, 1593, 1710, 1870],
            vec![521, 682, 1337, 1395, 1764]
        )
    ); // []
}
