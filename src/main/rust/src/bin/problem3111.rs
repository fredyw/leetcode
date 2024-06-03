// https://leetcode.com/problems/minimum-rectangles-to-cover-points/description/
pub fn min_rectangles_to_cover_points(mut points: Vec<Vec<i32>>, w: i32) -> i32 {
    points.sort_by(|a, b| a[0].cmp(&b[0]));
    let mut answer = 1;
    let mut x = points[0][0];
    for point in points {
        if x + w < point[0] {
            x = point[0];
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        min_rectangles_to_cover_points(
            vec![
                vec![2, 1],
                vec![1, 0],
                vec![1, 4],
                vec![1, 8],
                vec![3, 5],
                vec![4, 6]
            ],
            1
        )
    ); // 2
    println!(
        "{}",
        min_rectangles_to_cover_points(
            vec![
                vec![0, 0],
                vec![1, 1],
                vec![2, 2],
                vec![3, 3],
                vec![4, 4],
                vec![5, 5],
                vec![6, 6]
            ],
            2
        )
    ); // 3
    println!(
        "{}",
        min_rectangles_to_cover_points(vec![vec![2, 3], vec![1, 2]], 0)
    ); // 2
}
