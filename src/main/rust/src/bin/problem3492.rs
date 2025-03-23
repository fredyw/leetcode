// https://leetcode.com/problems/maximum-containers-on-a-ship/description/
pub fn max_containers(n: i32, w: i32, max_weight: i32) -> i32 {
    let total_cells = n * n;
    let total_weight = total_cells * w;
    if total_weight <= max_weight {
        total_cells
    } else {
        max_weight / w
    }
}

fn main() {
    println!("{}", max_containers(2, 3, 15)); // 4
    println!("{}", max_containers(3, 5, 20)); // 4
    println!("{}", max_containers(5, 8, 70)); // 8
}
