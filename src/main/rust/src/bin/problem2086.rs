// https://leetcode.com/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses/
pub fn minimum_buckets(street: String) -> i32 {
    todo!()
}

fn main() {
    println!("{}", minimum_buckets(String::from("H..H"))); // 2
    println!("{}", minimum_buckets(String::from(".H.H."))); // 1
    println!("{}", minimum_buckets(String::from(".HHH."))); // -1
    println!("{}", minimum_buckets(String::from(".H..H..H."))); // 3
    println!("{}", minimum_buckets(String::from(".H.H..H."))); // 2
    println!("{}", minimum_buckets(String::from(".H.H.H."))); // 2
    println!("{}", minimum_buckets(String::from("HH..HH"))); // -1
}
