#[derive(Debug, PartialEq, Eq)]
pub enum NestedInteger {
    Int(i32),
    List(Vec<NestedInteger>),
}

// https://leetcode.com/problems/nested-list-weight-sum-ii/description/
pub fn depth_sum_inverse(nested_list: Vec<NestedInteger>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        depth_sum_inverse(vec![
            NestedInteger::List(vec![NestedInteger::Int(1), NestedInteger::Int(1)]),
            NestedInteger::Int(2),
            NestedInteger::List(vec![NestedInteger::Int(1), NestedInteger::Int(1)])
        ])
    ); // 8
    println!(
        "{}",
        depth_sum_inverse(vec![
            NestedInteger::Int(1),
            NestedInteger::List(vec![
                NestedInteger::Int(4),
                NestedInteger::List(vec![NestedInteger::Int(6)])
            ])
        ])
    ); // 17
}
