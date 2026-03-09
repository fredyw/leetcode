// https://leetcode.com/problems/minimum-capacity-box/description/
pub fn minimum_index(capacity: Vec<i32>, item_size: i32) -> i32 {
    let mut answer = -1;
    let mut min_capacity = i32::MAX;
    for i in 0..capacity.len() {
        if capacity[i] >= item_size {
            if min_capacity == i32::MAX || min_capacity > capacity[i] {
                answer = i as i32;
                min_capacity = capacity[i];
            }
        }
    }
    answer
}

fn main() {
    println!("{}", minimum_index(vec![1, 5, 3, 7], 3)); // 2
    println!("{}", minimum_index(vec![3, 5, 4, 3], 2)); // 0
    println!("{}", minimum_index(vec![4], 5)); // -1
}
