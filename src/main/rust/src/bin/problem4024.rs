// https://leetcode.com/problems/nearest-available-drone/description/
pub fn nearest_drone(drones: Vec<Vec<i32>>, target: Vec<i32>) -> i32 {
    let mut answer = -1;
    let mut min_distance = i32::MAX;
    for (i, drone) in drones.iter().enumerate() {
        let distance = (drone[0] - target[0]).abs() + (drone[1] - target[1]).abs();
        let target = drone[2];
        if distance <= target {
            if min_distance == i32::MAX {
                min_distance = distance;
                answer = i as i32;
            } else if min_distance > distance {
                min_distance = distance;
                answer = i as i32;
            }
        }
    }
    if answer == i32::MAX { -1 } else { answer }
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
