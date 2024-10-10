// https://leetcode.com/problems/put-boxes-into-the-warehouse-i/description/
pub fn max_boxes_in_warehouse(mut boxes: Vec<i32>, warehouse: Vec<i32>) -> i32 {
    let mut prefix_min: Vec<i32> = vec![];
    for (i, w) in warehouse.into_iter().enumerate() {
        if i == 0 {
            prefix_min.push(w);
        } else {
            prefix_min.push(prefix_min[i - 1].min(w));
        }
    }
    boxes.sort();
    let mut answer = 0;
    let mut i: isize = prefix_min.len() as isize - 1;
    let mut j = 0;
    while i >= 0 && j < boxes.len() {
        let mut k = j;
        while k < boxes.len() {
            if boxes[k] <= prefix_min[i as usize] {
                answer += 1;
                j += 1;
                break;
            }
            k += 1;
        }
        i -= 1;
    }
    answer
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
