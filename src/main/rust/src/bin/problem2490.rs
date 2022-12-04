// https://leetcode.com/problems/circular-sentence/
pub fn is_circular_sentence(sentence: String) -> bool {
    let v: Vec<&[u8]> = sentence.split(' ').map(|w| w.as_bytes()).collect();
    for i in 0..v.len() {
        if v[i][v[i].len() - 1] != v[(i + 1) % v.len()][0] {
            return false;
        }
    }
    true
}

fn main() {
    println!(
        "{}",
        is_circular_sentence("leetcode exercises sound delightful".to_string())
    ); // true
    println!("{}", is_circular_sentence("eetcode".to_string())); // true
    println!("{}", is_circular_sentence("Leetcode is cool".to_string())); // false
}
