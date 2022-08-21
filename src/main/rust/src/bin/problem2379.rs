// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
    let chars: Vec<char> = blocks.chars().collect();
    let mut white_count = 0;
    let mut i = 0;
    while i < chars.len() && i < k as usize {
        if chars[i] == 'W' {
            white_count += 1;
        }
        i += 1;
    }
    let mut answer = white_count;
    while i < chars.len() {
        if chars[i - k as usize] == 'W' {
            white_count -= 1;
        }
        if chars[i] == 'W' {
            white_count += 1;
        }
        answer = answer.min(white_count);
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_recolors("WBBWWBBWBW".to_string(), 7)); // 3
    println!("{}", minimum_recolors("WBWBBBW".to_string(), 2)); // 0
    println!("{}", minimum_recolors("BWWWBB".to_string(), 6)); // 3
}
