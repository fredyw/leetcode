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
    let mut i = 1;
    let mut j = warehouse.len() - 2;
    while i < warehouse_min_index || j > warehouse_min_index {
        if i < warehouse_min_index {
            warehouse[i] = warehouse[i].min(warehouse[i - 1]);
        }
        if j > warehouse_min_index {
            warehouse[j] = warehouse[j].min(warehouse[j + 1]);
        }
        i += 1;
        j -= 1;
    }
    let mut box_index = 0;
    let mut answer = if warehouse_min_value >= boxes[0] {
        box_index += 1;
        1
    } else {
        0
    };
    let mut warehouse_left_index = warehouse_min_index as i32 - 1;
    let mut warehouse_right_index = warehouse_min_index as i32 + 1;
    while (warehouse_left_index >= 0 || warehouse_right_index < warehouse.len() as i32)
        && box_index < boxes.len()
    {
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
            if warehouse[warehouse_left_index as usize] >= boxes[box_index] {
                answer += 1;
                box_index += 1;
            }
            warehouse_left_index -= 1;
        } else if can_go_right {
            if warehouse[warehouse_right_index as usize] >= boxes[box_index] {
                answer += 1;
                box_index += 1;
            }
            warehouse_right_index += 1;
        }
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
    // println!(
    //     "{}",
    //     max_boxes_in_warehouse(vec![1, 2, 3], vec![1, 2, 3, 4])
    // ); // 3
    // println!(
    //     "{}",
    //     max_boxes_in_warehouse(vec![4, 5, 6, 2], vec![3, 2, 6, 3, 3, 7])
    // ); // 2
    println!("{}", max_boxes_in_warehouse(vec![1], vec![1])); // 2
}
