// https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/
pub fn max_boxes_in_warehouse(mut boxes: Vec<i32>, warehouse: Vec<i32>) -> i32 {
    boxes.sort();
    let mut warehouse_min_index = 0;
    let mut warehouse_min_value = i32::MAX;
    for (i, val) in warehouse.iter().enumerate() {
        if *val < warehouse_min_value {
            warehouse_min_value = *val;
            warehouse_min_index = i;
        }
    }
    let mut answer = 0;
    let mut box_index = 0;
    let mut warehouse_left_index = warehouse_min_index as i32 - 1;
    let mut warehouse_right_index = warehouse_min_index as i32 + 1;
    while warehouse_left_index >= 0 || warehouse_right_index < warehouse.len() as i32 {
        let mut can_go_left = false;
        let mut can_go_right = false;
        if warehouse_left_index < 0 {
            can_go_right = true;
        } else if warehouse_right_index == warehouse.len() as i32 {
            can_go_left = true;
        } else {
            if warehouse[warehouse_left_index as usize] < warehouse[warehouse_right_index as usize]
            {
                can_go_left = true;
            } else {
                can_go_right = true;
            }
        }
        if can_go_left {
            if warehouse[warehouse_left_index as usize] < boxes[box_index] {
                break;
            }
            warehouse_left_index -= 1;
        } else if can_go_right {
            if warehouse[warehouse_right_index as usize] < boxes[box_index] {
                break;
            }
            warehouse_right_index += 1;
        }
        box_index += 1;
        answer += 1;
    }
    answer
}

fn main() {
    // println!(
    //     "{}",
    //     max_boxes_in_warehouse(vec![1, 2, 2, 3, 4], vec![3, 4, 1, 2])
    // ); // 4
    // println!(
    //     "{}",
    //     max_boxes_in_warehouse(vec![3, 5, 5, 2], vec![2, 1, 3, 4, 5])
    // ); // 3
    // println!("{}", max_boxes_in_warehouse(vec![1, 2, 3], vec![3, 2, 4])); // 3
    // println!("{}", max_boxes_in_warehouse(vec![1, 2, 3], vec![3, 4, 2])); // 3
    // println!("{}", max_boxes_in_warehouse(vec![2, 2, 2], vec![1, 1, 1])); // 0
    println!(
        "{}",
        max_boxes_in_warehouse(vec![1, 2, 3], vec![1, 2, 3, 4])
    ); // 3
}
