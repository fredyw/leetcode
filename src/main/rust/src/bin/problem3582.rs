// https://leetcode.com/problems/generate-tag-for-video-caption/description/
pub fn generate_tag(caption: String) -> String {
    let split: Vec<&str> = caption.split(" ").filter(|w| !w.is_empty()).collect();
    "".to_string()
}

fn main() {
    println!(
        "{}",
        generate_tag("Leetcode daily streak achieved".to_string())
    ); // "#leetcodeDailyStreakAchieved"
    println!("{}", generate_tag("can I Go There".to_string())); // "#canIGoThere"
    println!("{}", generate_tag("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh".to_string()));
    // "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
    println!("{}", generate_tag("can I Go    There".to_string())); // "#canIGoThere"
}
