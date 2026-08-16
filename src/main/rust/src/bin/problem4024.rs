// https://leetcode.com/problems/nearest-available-drone/description/
pub fn nearest_drone(drones: Vec<Vec<i32>>, target: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        nearest_drone(vec![vec![0, 0, 8], vec![2, 2, 9]], vec![3, 4])
    ); // 1
    println!(
        "{}",
        nearest_drone(
            vec![vec![2, 1, 5], vec![4, 4, 5], vec![6, 6, 8]],
            vec![5, 5]
        )
    ); // 1
    println!("{}", nearest_drone(vec![vec![4, 4, 5]], vec![8, 6])); // -1
}
