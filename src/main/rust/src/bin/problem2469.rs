// https://leetcode.com/problems/convert-the-temperature/
pub fn convert_temperature(celsius: f64) -> Vec<f64> {
    vec![celsius + 273.15, (celsius * 1.80) + 32.00]
}

fn main() {
    println!("{:?}", convert_temperature(36.50)); // [309.65000,97.70000]
    println!("{:?}", convert_temperature(122.11)); // [395.26000,251.79800]
}
