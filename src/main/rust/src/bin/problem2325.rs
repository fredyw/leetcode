use std::collections::HashMap;

// https://leetcode.com/problems/decode-the-message/
pub fn decode_message(key: String, message: String) -> String {
    let mut map: HashMap<char, char> = HashMap::new();
    let mut i = 0;
    for from in key.chars().into_iter().collect::<Vec<char>>() {
        if from == ' ' {
            continue;
        }
        let to = ('a' as u8 + i) as char;
        if !map.contains_key(&from) {
            map.insert(from, to);
            i += 1;
        }
        if i == 26 {
            break;
        }
    }
    let mut answer = String::from("");
    for c in message.chars().into_iter().collect::<Vec<char>>() {
        match map.get(&c) {
            Some(a) => answer.push(*a),
            None => answer.push(c),
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        decode_message(
            String::from("the quick brown fox jumps over the lazy dog"),
            String::from("vkbs bs t suepuv")
        )
    ); // "this is a secret"
    println!(
        "{}",
        decode_message(
            String::from("eljuxhpwnyrdgtqkviszcfmabo"),
            String::from("zwx hnfx lqantp mnoeius ycgk vcnjrdb")
        )
    ); // "the five boxing wizards jump quickly"
}
