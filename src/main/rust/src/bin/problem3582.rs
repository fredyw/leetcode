// https://leetcode.com/problems/generate-tag-for-video-caption/description/
pub fn generate_tag(caption: String) -> String {
    let split: Vec<String> = caption
        .split(" ")
        .filter(|w| !w.is_empty())
        .enumerate()
        .map(|(i, w)| {
            let w = w.to_lowercase();
            if i == 0 {
                format!("{}{}", &w[0..1].to_lowercase(), &w[1..])
            } else {
                format!("{}{}", &w[0..1].to_uppercase(), &w[1..])
            }
        })
        .collect();
    let answer = format!("#{}", split.join(""));
    if answer.len() > 100 {
        answer[0..100].to_string()
    } else {
        answer
    }
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
    println!(
        "{}",
        generate_tag("Leetcode dAIly streak achieved".to_string())
    ); // "#leetcodeDailyStreakAchieved"
}
