// https://leetcode.com/problems/put-boxes-into-the-warehouse-i/description/
pub fn max_boxes_in_warehouse(boxes: Vec<i32>, warehouse: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_boxes_in_warehouse(vec![4, 3, 4, 1], vec![5, 3, 3, 4, 1])
    ); // 3
    println!(
        "{}",
        max_boxes_in_warehouse(vec![1, 2, 2, 3, 4], vec![3, 4, 1, 2])
    ); // 3
    println!(
        "{}",
        max_boxes_in_warehouse(vec![1, 2, 3], vec![1, 2, 3, 4])
    ); // 1
    println!(
        "{}",
        max_boxes_in_warehouse(vec![1, 5, 3, 4, 2], vec![2, 5, 3, 3, 4, 1])
    ); // 2
}
