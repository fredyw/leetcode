use std::collections::HashSet;

// https://leetcode.com/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses/
pub fn minimum_buckets(street: String) -> i32 {
    let mut i = 0;
    let chars: Vec<char> = street.chars().collect();
    let mut buckets: HashSet<usize> = HashSet::new();
    let mut house_count = 0;
    while i < chars.len() {
        if chars[i] == 'H' {
            house_count += 1;
        }
        if (i == 0 && i + 1 < chars.len() && chars[i] == 'H' && chars[i + 1] == 'H')
            || (i > 0 && i == chars.len() - 1 && chars[i] == 'H' && chars[i - 1] == 'H')
            || i > 0
                && i + 1 < chars.len()
                && chars[i - 1] == 'H'
                && chars[i] == 'H'
                && chars[i + 1] == 'H'
        {
            return -1;
        }
        if i != 0 && buckets.contains(&(i - 1)) {
            i += 1;
            continue;
        }
        if i + 1 < chars.len() && chars[i] == 'H' && chars[i + 1] == '.' {
            buckets.insert(i + 1);
        } else if i != 0 && chars[i] == 'H' && chars[i - 1] == '.' {
            buckets.insert(i - 1);
        }
        i += 1;
    }
    if house_count == 0 {
        0
    } else if buckets.len() == 0 {
        -1
    } else {
        buckets.len() as i32
    }
}

fn main() {
    println!("{}", minimum_buckets(String::from("H..H"))); // 2
    println!("{}", minimum_buckets(String::from(".H.H."))); // 1
    println!("{}", minimum_buckets(String::from(".HHH."))); // -1
    println!("{}", minimum_buckets(String::from(".H..H..H."))); // 3
    println!("{}", minimum_buckets(String::from(".H.H..H."))); // 2
    println!("{}", minimum_buckets(String::from(".H.H.H."))); // 2
    println!("{}", minimum_buckets(String::from("HH..HH"))); // -1
    println!("{}", minimum_buckets(String::from("H"))); // -1
    println!("{}", minimum_buckets(String::from("...."))); // 0
    println!("{}", minimum_buckets(String::from(".HH.H.H.H.."))); // 3
}
