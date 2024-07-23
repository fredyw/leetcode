// https://leetcode.com/problems/lonely-pixel-i/description/
pub fn find_lonely_pixel(picture: Vec<Vec<char>>) -> i32 {
    let max_rows = picture.len();
    let max_cols = if max_rows > 0 { picture[0].len() } else { 0 };
    let mut row_counts: Vec<i32> = vec![0; max_rows];
    let mut col_counts: Vec<i32> = vec![0; max_cols];
    for i in 0..max_rows {
        for j in 0..max_cols {
            if picture[i][j] == 'B' {
                row_counts[i] += 1;
                col_counts[j] += 1;
            }
        }
    }
    let mut answer = 0;
    for i in 0..max_rows {
        for j in 0..max_cols {
            if picture[i][j] == 'B' {
                if row_counts[i] == 1 && col_counts[j] == 1 {
                    answer += 1;
                }
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        find_lonely_pixel(vec![
            vec!['W', 'W', 'B'],
            vec!['W', 'B', 'W'],
            vec!['B', 'W', 'W']
        ])
    ); // 3
    println!(
        "{}",
        find_lonely_pixel(vec![
            vec!['B', 'B', 'B'],
            vec!['B', 'B', 'W'],
            vec!['B', 'B', 'B']
        ])
    ); // 0
    println!(
        "{}",
        find_lonely_pixel(vec![
            vec!['W', 'W', 'B'],
            vec!['W', 'B', 'W'],
            vec!['B', 'B', 'W']
        ])
    ); // 1
}
