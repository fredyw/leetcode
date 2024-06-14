#[derive(Debug, PartialEq, Eq)]
pub enum NestedInteger {
    Int(i32),
    List(Vec<NestedInteger>),
}

// https://leetcode.com/problems/nested-list-weight-sum/description/
pub fn depth_sum(nested_list: Vec<NestedInteger>) -> i32 {
    todo!()
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
