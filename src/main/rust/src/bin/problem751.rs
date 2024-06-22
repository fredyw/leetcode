// https://leetcode.com/problems/ip-to-cidr/description/
pub fn ip_to_cidr(ip: String, n: i32) -> Vec<String> {
    todo!()
}

fn main() {
    println!("{:?}", ip_to_cidr("255.0.0.7".to_string(), 10)); // ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
    println!("{:?}", ip_to_cidr("117.145.102.62".to_string(), 8)); // ["117.145.102.62/31","117.145.102.64/30","117.145.102.68/31"]
    println!("{:?}", ip_to_cidr("0.0.0.0".to_string(), 2)); // ["0.0.0.0/31"]
}
