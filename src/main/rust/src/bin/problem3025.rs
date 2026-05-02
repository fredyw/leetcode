// https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/description/
pub fn number_of_pairs(mut points: Vec<Vec<i32>>) -> i32 {
    let mut answer = 0;
    points.sort_by(|a, b| {
        if a[0] == b[0] {
            b[1].cmp(&a[1])
        } else {
            a[0].cmp(&b[0])
        }
    });
    for i in 0..points.len() {
        let y_a = points[i][1];
        let mut max_y_seen = i32::MIN;
        for j in (i + 1)..points.len() {
            let y_b = points[j][1];
            if y_b <= y_a {
                if y_b > max_y_seen {
                    answer += 1;
                    max_y_seen = y_b;
                }
            }
            if max_y_seen == y_a {
                break;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        number_of_pairs(vec![vec![1, 1], vec![2, 2], vec![3, 3]])
    ); // 0
    println!(
        "{}",
        number_of_pairs(vec![vec![6, 2], vec![4, 4], vec![2, 6]])
    ); // 2
    println!(
        "{}",
        number_of_pairs(vec![vec![3, 1], vec![1, 3], vec![1, 1]])
    ); // 2
}
