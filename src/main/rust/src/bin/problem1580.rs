// https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/
pub fn max_boxes_in_warehouse(mut boxes: Vec<i32>, mut warehouse: Vec<i32>) -> i32 {
    boxes.sort();
    let mut warehouse_min_index = 0;
    let mut warehouse_min_value = i32::MAX;
    for (i, val) in warehouse.iter().enumerate() {
        if *val < warehouse_min_value {
            warehouse_min_value = *val;
            warehouse_min_index = i;
        }
    }
    let mut i = 0;
    let mut j = warehouse.len() - 1;
    while i < warehouse_min_index || j > warehouse_min_index {
        if i < warehouse_min_index {
            warehouse[i] = if i == 0 {
                warehouse[i]
            } else {
                warehouse[i].min(warehouse[i - 1])
            };
        }
        if j > warehouse_min_index {
            warehouse[j] = if j == warehouse.len() - 1 {
                warehouse[j]
            } else {
                warehouse[j].min(warehouse[j + 1])
            };
        }
        i += 1;
        j -= 1;
    }
    warehouse.sort();
    let mut answer = 0;
    let mut box_index = 0;
    let mut warehouse_index = 0;
    while box_index < boxes.len() && warehouse_index < warehouse.len() {
        if boxes[box_index] <= warehouse[warehouse_index] {
            answer += 1;
            box_index += 1;
        }
        warehouse_index += 1;
    }
    answer
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
    println!("{}", max_boxes_in_warehouse(vec![2, 2, 2], vec![1, 1, 1])); // 0
    println!(
        "{}",
        max_boxes_in_warehouse(vec![1, 2, 3], vec![1, 2, 3, 4])
    ); // 3
    println!(
        "{}",
        max_boxes_in_warehouse(vec![4, 5, 6, 2], vec![3, 2, 6, 3, 3, 7])
    ); // 2
    println!("{}", max_boxes_in_warehouse(vec![1], vec![1])); // 1
}
