// https://leetcode.com/problems/categorize-box-according-to-criteria/
pub fn categorize_box(length: i32, width: i32, height: i32, mass: i32) -> String {
    let mut category1 = "";
    let mut category2 = "";
    let volume: i64 = length as i64 * width as i64 * height as i64;
    if length >= 10_000 || width >= 10_000 || height >= 10_000 || volume >= 1_000_000_000 {
        category1 = "Bulky"
    }
    if mass >= 100 {
        category2 = "Heavy"
    }
    if category1 == "Bulky" && category2 == "Heavy" {
        return "Both".to_string();
    }
    if category1 == "Bulky" && category2 != "Heavy" {
        return "Bulky".to_string();
    }
    if category1 != "Bulky" && category2 == "Heavy" {
        return "Heavy".to_string();
    }
    "Neither".to_string()
}

fn main() {
    // println!("{}", categorize_box(1000, 35, 700, 300)); // "Heavy"
    // println!("{}", categorize_box(200, 50, 800, 50)); // "Neither"
    println!("{}", categorize_box(2909, 3968, 3272, 727)); // "Both"
}
