// https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
pub fn kth_largest_number(nums: Vec<String>, k: i32) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        kth_largest_number(
            vec![
                String::from("3"),
                String::from("6"),
                String::from("7"),
                String::from("10")
            ],
            4
        )
    ); // "3"
    println!(
        "{}",
        kth_largest_number(
            vec![
                String::from("2"),
                String::from("21"),
                String::from("12"),
                String::from("1")
            ],
            3
        )
    ); // "2"
    println!(
        "{}",
        kth_largest_number(vec![String::from("0"), String::from("0")], 2)
    ); // "0"
}
