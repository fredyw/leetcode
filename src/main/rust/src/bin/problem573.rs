// https://leetcode.com/problems/squirrel-simulation/description/
pub fn min_distance(
    height: i32,
    width: i32,
    tree: Vec<i32>,
    squirrel: Vec<i32>,
    nuts: Vec<Vec<i32>>,
) -> i32 {
    fn distance(x1: i32, y1: i32, x2: i32, y2: i32) -> i32 {
        (x1 - x2).abs() + (y1 - y2).abs()
    }

    let mut min_distance = i32::MAX;
    let mut min_x = 0;
    let mut min_y = 0;
    for nut in nuts.iter() {
        let distance = distance(squirrel[0], squirrel[1], nut[0], nut[1]);
        if distance < min_distance {
            min_distance = distance;
            min_x = nut[0];
            min_y = nut[1];
        }
    }
    let mut answer = min_distance;
    let mut x = min_x;
    let mut y = min_y;
    for nut in nuts.iter() {
        if nut[0] == min_x && nut[1] == min_y {
            continue;
        }
        answer += distance(x, y, nut[0], nut[1]);
        x = nut[0];
        y = nut[1];
    }
    answer += distance(x, y, tree[0], tree[1]);
    answer
}

fn main() {
    println!(
        "{}",
        min_distance(5, 7, vec![2, 2], vec![4, 4], vec![vec![3, 0], vec![2, 5]])
    ); // 12
    println!(
        "{}",
        min_distance(1, 3, vec![0, 1], vec![0, 0], vec![vec![0, 2]])
    ); // 3
}
