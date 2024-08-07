// https://leetcode.com/problems/wiggle-sort/
pub fn wiggle_sort(nums: &mut Vec<i32>) {
    nums.sort();
    let mut i = 1;
    while i < nums.len() - 1 {
        nums.swap(i, i + 1);
        i += 2;
    }
}

fn main() {
    let mut nums = vec![3, 5, 2, 1, 6, 4];
    wiggle_sort(&mut nums);
    println!("{:?}", nums); // [3,5,1,6,2,4]

    let mut nums = vec![6, 6, 5, 6, 3, 8];
    wiggle_sort(&mut nums);
    println!("{:?}", nums); // [6,6,5,6,3,8]
}
