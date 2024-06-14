#[derive(Debug, PartialEq, Eq)]
pub enum NestedInteger {
    Int(i32),
    List(Vec<NestedInteger>),
}

// https://leetcode.com/problems/nested-list-weight-sum/description/
pub fn depth_sum(nested_list: Vec<NestedInteger>) -> i32 {
    fn depth_sum(nested_list: &Vec<NestedInteger>, depth: i32) -> i32 {
        let mut sum = 0;
        for nested in nested_list.iter() {
            sum += match nested {
                NestedInteger::Int(i) => i * depth,
                NestedInteger::List(v) => depth_sum(v, depth + 1),
            }
        }
        sum
    }

    depth_sum(&nested_list, 1)
}

fn main() {
    println!(
        "{}",
        depth_sum(vec![
            NestedInteger::List(vec![NestedInteger::Int(1), NestedInteger::Int(1)]),
            NestedInteger::Int(2),
            NestedInteger::List(vec![NestedInteger::Int(1), NestedInteger::Int(1)]),
        ])
    ); // 10
    println!(
        "{}",
        depth_sum(vec![
            NestedInteger::Int(1),
            NestedInteger::List(vec![
                NestedInteger::Int(4),
                NestedInteger::List(vec![NestedInteger::Int(6)])
            ]),
        ])
    ); // 27
    println!("{}", depth_sum(vec![NestedInteger::Int(0)])); // 0
}
