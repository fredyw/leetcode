// https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/
pub fn max_boxes_in_warehouse(boxes: Vec<i32>, warehouse: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_boxes_in_warehouse(vec![1, 2, 2, 3, 4], vec![3, 4, 1, 2])
    ); // 4
    println!(
        "{}",
        max_boxes_in_warehouse(vec![3, 5, 5, 2], vec![2, 1, 3, 4, 5])
    ); // 3
    println!("{}", max_boxes_in_warehouse(vec![1, 2, 3], vec![3, 2, 4])); // 3
    println!("{}", max_boxes_in_warehouse(vec![1, 2, 3], vec![3, 4, 2])); // 3
}
