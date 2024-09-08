// https://leetcode.com/problems/convert-date-to-binary/description/
pub fn convert_date_to_binary(date: String) -> String {
    let split: Vec<&str> = date.split("-").collect();
    format!(
        "{:b}-{:b}-{:b}",
        split[0].parse::<i32>().unwrap(),
        split[1].parse::<i32>().unwrap(),
        split[2].parse::<i32>().unwrap()
    )
}

fn main() {
    println!("{}", convert_date_to_binary("2080-02-29".to_string())); // "100000100000-10-11101"
    println!("{}", convert_date_to_binary("1900-01-01".to_string())); // "11101101100-1-1"
}
