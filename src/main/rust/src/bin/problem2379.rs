// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
    let mut answer = i32::MAX;
    let chars: Vec<char> = blocks.chars().collect();
    for i in 0..=blocks.len() - k as usize {
        let mut white_count = 0;
        for j in i..i + k as usize {
            if chars[j] == 'W' {
                white_count += 1;
            }
        }
        answer = answer.min(white_count);
    }
    answer
}

fn main() {
    println!("{}", minimum_recolors("WBBWWBBWBW".to_string(), 7)); // 3
    println!("{}", minimum_recolors("WBWBBBW".to_string(), 2)); // 0
    println!("{}", minimum_recolors("BWWWBB".to_string(), 6)); // 3
}
