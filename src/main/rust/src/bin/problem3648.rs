// https://leetcode.com/problems/minimum-sensors-to-cover-grid/description/
pub fn min_sensors(n: i32, m: i32, k: i32) -> i32 {
    let mut answer = 0;
    let mut row = k;
    while row < n {
        let mut col = k;
        while col < m {
            col += (k * 2) + 1;
            answer += 1;
        }
        if col - k < m {
            answer += 1;
        }
        row += (k * 2) + 1;
    }
    if row - k < n {
        let mut col = k;
        while col < m {
            col += (k * 2) + 1;
            answer += 1;
        }
        if col - k < m {
            answer += 1;
        }
        answer
    } else {
        answer
    }
}

fn main() {
    println!("{}", min_sensors(5, 5, 1)); // 4
    println!("{}", min_sensors(2, 2, 2)); // 1
    println!("{}", min_sensors(6, 5, 1)); // 4
    println!("{}", min_sensors(44, 69, 8)); // 15
    println!("{}", min_sensors(88, 26, 10)); // 10
}
