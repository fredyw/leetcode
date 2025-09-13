// https://leetcode.com/problems/minimum-sensors-to-cover-grid/description/
pub fn min_sensors(n: i32, m: i32, k: i32) -> i32 {
    let mut answer = 0;
    let mut row = k;
    while row < n {
        let mut col = k;
        while col < m {
            println!("({row}, {col})");
            col += k + 1;
            answer += 1;
        }
        row += k + 1;
    }
    if answer == 0 {
        1
    } else {
        answer
    }
}

fn main() {
    // println!("{}", min_sensors(5, 5, 1)); // 4
    // println!("{}", min_sensors(2, 2, 2)); // 1
    println!("{}", min_sensors(6, 5, 1)); // 4
                                          // println!("{}", min_sensors(44, 69, 8)); // 15
}
