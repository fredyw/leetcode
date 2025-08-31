use std::collections::HashSet;

// https://leetcode.com/problems/restore-finishing-order/description/
pub fn recover_order(order: Vec<i32>, friends: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![];
    let friends: HashSet<i32> = friends.iter().cloned().collect();
    for o in order {
        if friends.contains(&o) {
            answer.push(o);
        }
    }
    answer
}

fn main() {
    println!("{:?}", recover_order(vec![3, 1, 2, 5, 4], vec![1, 3, 4])); // [3,1,4]
    println!("{:?}", recover_order(vec![1, 4, 5, 3, 2], vec![2, 5])); // [5,2]
}
