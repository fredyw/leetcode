use std::collections::HashMap;

// https://leetcode.com/problems/toggle-light-bulbs/description/
pub fn toggle_light_bulbs(bulbs: Vec<i32>) -> Vec<i32> {
    let mut answer: HashMap<i32, bool> = HashMap::new();
    for i in 0..bulbs.len() {
        if let Some(on) = answer.get_mut(&bulbs[i]) {
            *on = !*on;
        } else {
            answer.insert(bulbs[i], true);
        }
    }
    let mut answer: Vec<i32> = answer
        .into_iter()
        .filter(|(_, on)| *on)
        .map(|(bulb, _)| bulb)
        .collect();
    answer.sort_unstable();
    answer
}

fn main() {
    println!("{:?}", toggle_light_bulbs(vec![10, 30, 20, 10])); // [20,30]
    println!("{:?}", toggle_light_bulbs(vec![100, 100])); // []
}
