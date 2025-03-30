// https://leetcode.com/problems/minimum-cost-to-reach-every-position/description/
pub fn min_costs(cost: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![];
    let mut min = i32::MAX;
    for c in cost {
        min = min.min(c);
        answer.push(min);
    }
    answer
}

fn main() {
    println!("{:?}", min_costs(vec![5, 3, 4, 1, 3, 2])); // [5,3,3,1,1,1]
    println!("{:?}", min_costs(vec![1, 2, 4, 6, 7])); // [1,1,1,1,1]
}
