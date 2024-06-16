// https://leetcode.com/problems/missing-ranges/
pub fn find_missing_ranges(nums: Vec<i32>, lower: i32, upper: i32) -> Vec<Vec<i32>> {
    todo!()
}

fn main() {
    println!("{:?}", find_missing_ranges(vec![0, 1, 3, 50, 75], 0, 99)); // [[2,2],[4,49],[51,74],[76,99]]
    println!("{:?}", find_missing_ranges(vec![-1], -1, -1)); // []
}
