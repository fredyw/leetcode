use std::collections::HashMap;

// https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/
pub fn interchangeable_rectangles(rectangles: Vec<Vec<i32>>) -> i64 {
    fn gcd(a: i32, b: i32) -> i32 {
        if a == b {
            return a;
        }
        if a > b {
            return gcd(a - b, b);
        }
        gcd(a, b - a)
    }

    fn series(n: i32, a: i32, b: i32) -> i64 {
        ((n as f64 / 2.0) * (a + b) as f64) as i64
    }

    let mut answer: i64 = 0;
    let mut map: HashMap<String, i32> = HashMap::new();
    for rectangle in rectangles.into_iter() {
        let gcd = gcd(rectangle[0], rectangle[1]);
        let s = format!("{}/{}", rectangle[0] / gcd, rectangle[1] / gcd);
        let count = map.get(&s).unwrap_or(&0) + 1;
        map.insert(s, count);
    }
    answer += map
        .into_iter()
        .map(|a| series(a.1 - 1, 1, a.1 - 1))
        .sum::<i64>();
    answer
}

fn main() {
    println!(
        "{}",
        interchangeable_rectangles(vec![vec![4, 8], vec![3, 6], vec![10, 20], vec![15, 30]])
    ); // 6
    println!(
        "{}",
        interchangeable_rectangles(vec![vec![4, 5], vec![7, 8]])
    ); // 0
    println!(
        "{}",
        interchangeable_rectangles(vec![vec![3, 4], vec![6, 8], vec![9, 12]])
    ); // 3
    println!(
        "{}",
        interchangeable_rectangles(vec![
            vec![4, 8],
            vec![3, 6],
            vec![10, 20],
            vec![15, 30],
            vec![3, 4],
            vec![6, 8],
            vec![9, 12]
        ])
    ); // 9
}
