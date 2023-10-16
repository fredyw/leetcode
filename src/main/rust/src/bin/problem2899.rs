// https://leetcode.com/problems/last-visited-integers/description/
pub fn last_visited_integers(words: Vec<String>) -> Vec<i32> {
    let mut answer = vec![];
    let mut nums: Vec<&str> = vec![];
    let mut i: i32 = 0;
    for word in words.iter() {
        if word != "prev" {
            nums.push(word);
            i = nums.len() as i32 - 1;
        } else {
            if i < 0 || nums.is_empty() {
                answer.push(-1);
            } else {
                answer.push(nums[i as usize].parse().unwrap());
                i -= 1;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        last_visited_integers(vec![
            "1".to_string(),
            "2".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string()
        ])
    ); // [2,1,-1]
    println!(
        "{:?}",
        last_visited_integers(vec![
            "1".to_string(),
            "prev".to_string(),
            "2".to_string(),
            "prev".to_string(),
            "prev".to_string()
        ])
    ); // [1,2,1]
    println!(
        "{:?}",
        last_visited_integers(vec![
            "1".to_string(),
            "2".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "3".to_string(),
            "prev".to_string()
        ])
    ); // [2,1,-1,-1,-1,3]
    println!(
        "{:?}",
        last_visited_integers(vec![
            "prev".to_string(),
            "prev".to_string(),
            "prev".to_string(),
            "27".to_string()
        ])
    ); // [-1,-1,-1]
}
