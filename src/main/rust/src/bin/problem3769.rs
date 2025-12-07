use std::cmp::Ordering;

// https://leetcode.com/problems/sort-integers-by-binary-reflection/description/
pub fn sort_by_reflection(mut nums: Vec<i32>) -> Vec<i32> {
    nums.sort_by(|a, b| {
        let rev_s1 = format!("{:b}", a).chars().rev().collect::<String>();
        let rev_s2 = format!("{:b}", b).chars().rev().collect::<String>();
        let rev1 = u32::from_str_radix(&rev_s1, 2).unwrap();
        let rev2 = u32::from_str_radix(&rev_s2, 2).unwrap();
        let ord = rev1.cmp(&rev2);
        match ord {
            Ordering::Equal => a.cmp(b),
            _ => ord,
        }
    });
    nums
}

fn main() {
    println!("{:?}", sort_by_reflection(vec![4, 5, 4])); // [4,4,5]
    println!("{:?}", sort_by_reflection(vec![3, 6, 5, 8])); // [8,3,6,5]
    println!("{:?}", sort_by_reflection(vec![8, 2])); // [2,8]
}
