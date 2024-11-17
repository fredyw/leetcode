#[derive(Debug, PartialEq, Eq)]
pub enum NestedInteger {
    Int(i32),
    List(Vec<NestedInteger>),
}

// https://leetcode.com/problems/nested-list-weight-sum-ii/description/
pub fn depth_sum_inverse(nested_list: Vec<NestedInteger>) -> i32 {
    fn max_depth(nested_list: &Vec<NestedInteger>, depth: i32, max: &mut i32) {
        for e in nested_list {
            match e {
                NestedInteger::Int(_) => {
                    *max = (*max).max(depth);
                }
                NestedInteger::List(list) => {
                    max_depth(list, depth + 1, max);
                }
            }
        }
    }

    fn depth_sum_inverse(nested_list: &Vec<NestedInteger>, max_depth: i32, depth: i32) -> i32 {
        let mut sum = 0;
        for e in nested_list {
            sum += match e {
                NestedInteger::Int(n) => n * (max_depth - depth + 1),
                NestedInteger::List(list) => depth_sum_inverse(list, max_depth, depth + 1),
            };
        }
        sum
    }

    let mut max = 0;
    max_depth(&nested_list, 1, &mut max);
    depth_sum_inverse(&nested_list, max, 1)
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
    NestedInteger::List(vec![]);
    println!(
        "{}",
        depth_sum_inverse(vec![
            NestedInteger::Int(1),
            NestedInteger::List(vec![NestedInteger::List(vec![])])
        ])
    ); // 2
}
