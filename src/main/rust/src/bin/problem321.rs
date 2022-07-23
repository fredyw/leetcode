// https://leetcode.com/problems/create-maximum-number/
pub fn max_number(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        max_number(vec![3, 4, 6, 5], vec![9, 1, 2, 5, 8, 3], 5)
    ); // [9,8,6,5,3]
    println!("{:?}", max_number(vec![6, 7], vec![6, 0, 4], 5)); // [6,7,6,0,4]
    println!("{:?}", max_number(vec![3, 9], vec![8, 9], 3)); // [9,8,9]
    println!("{:?}", max_number(vec![3, 9], vec![8, 9], 3)); // [9,8,9]
    println!("{:?}", max_number(vec![9, 8, 7], vec![1, 2], 4)); // [9,8,7,2]
    println!("{:?}", max_number(vec![3, 4, 6, 9], vec![9, 2, 5, 8, 9], 4)); // [9,9,5,8,9]
    println!(
        "{:?}",
        max_number(
            vec![5, 9, 3, 7, 5, 6, 2, 3],
            vec![3, 8, 1, 2, 8, 6, 0, 8],
            8
        )
    ); // [9,8,8,8,7,6,2,3]
}
