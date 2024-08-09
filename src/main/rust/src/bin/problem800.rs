// https://leetcode.com/problems/similar-rgb-color/description/
pub fn similar_rgb(color: String) -> String {
    let mut answer = String::new();
    let first_val1 = i32::from_str_radix(&color[1..3].chars().collect::<String>(), 16).unwrap();
    let second_val1 = i32::from_str_radix(&color[3..5].chars().collect::<String>(), 16).unwrap();
    let third_val1 = i32::from_str_radix(&color[5..7].chars().collect::<String>(), 16).unwrap();
    let mut min = i32::MAX;
    for i in 0..16 {
        let first_str = format!("{:x}{:x}", i, i);
        for j in 0..16 {
            let second_str = format!("{:x}{:x}", j, j);
            for k in 0..16 {
                let third_str = format!("{:x}{:x}", k, k);
                let first_val2 = i32::from_str_radix(&first_str, 16).unwrap();
                let second_val2 = i32::from_str_radix(&second_str, 16).unwrap();
                let third_val2 = i32::from_str_radix(&third_str, 16).unwrap();
                let val = (first_val1 - first_val2).abs()
                    + (second_val1 - second_val2).abs()
                    + (third_val1 - third_val2).abs();
                if val < min {
                    min = val;
                    answer = format!("#{}{}{}", first_str, second_str, third_str);
                }
            }
        }
    }
    answer
}

fn main() {
    println!("{}", similar_rgb("#09f166".to_string())); // "#11ee66"
    println!("{}", similar_rgb("#4e3fe1".to_string())); // "#5544dd"
    println!("{}", similar_rgb("#aabbcc".to_string())); // "#aabbcc"
    println!("{}", similar_rgb("#1c9e03".to_string())); // "#229900"
}
