// https://leetcode.com/problems/squirrel-simulation/description/
pub fn min_distance(
    _height: i32,
    _width: i32,
    tree: Vec<i32>,
    squirrel: Vec<i32>,
    nuts: Vec<Vec<i32>>,
) -> i32 {
    fn distance(x1: i32, y1: i32, x2: i32, y2: i32) -> i32 {
        (x1 - x2).abs() + (y1 - y2).abs()
    }

    let mut answer = 0;
    let mut max_distance = i32::MIN;
    for nut in nuts.iter() {
        answer += distance(tree[0], tree[1], nut[0], nut[1]) * 2;
        max_distance = max_distance.max(
            distance(nut[0], nut[1], tree[0], tree[1])
                - distance(nut[0], nut[1], squirrel[0], squirrel[1]),
        );
    }
    answer -= max_distance;
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
    println!(
        "{}",
        min_distance(
            5,
            5,
            vec![3, 2],
            vec![0, 1],
            vec![
                vec![2, 0],
                vec![4, 1],
                vec![0, 4],
                vec![1, 3],
                vec![1, 0],
                vec![3, 4],
                vec![3, 0],
                vec![2, 3],
                vec![0, 2],
                vec![0, 0],
                vec![2, 2],
                vec![4, 2],
                vec![3, 3],
                vec![4, 4],
                vec![4, 0],
                vec![4, 3],
                vec![3, 1],
                vec![2, 1],
                vec![1, 4],
                vec![2, 4]
            ]
        )
    ); // 100
    println!(
        "{}",
        min_distance(
            7,
            6,
            vec![5, 4],
            vec![3, 4],
            vec![
                vec![1, 4],
                vec![3, 0],
                vec![5, 0],
                vec![6, 1],
                vec![1, 3],
                vec![1, 1],
                vec![0, 3],
                vec![2, 2],
                vec![6, 3],
                vec![4, 1],
                vec![2, 4],
                vec![2, 1],
                vec![1, 0],
                vec![3, 2],
                vec![4, 2],
                vec![2, 5],
                vec![0, 2],
                vec![1, 2],
                vec![3, 3],
                vec![6, 2],
                vec![2, 0],
                vec![5, 1],
                vec![4, 5],
                vec![5, 2],
                vec![0, 1],
                vec![4, 0],
                vec![5, 3],
                vec![3, 5],
                vec![0, 5],
                vec![6, 4],
                vec![5, 5],
                vec![2, 3],
                vec![3, 1],
                vec![4, 4],
                vec![4, 3]
            ]
        )
    ); // 288
}
