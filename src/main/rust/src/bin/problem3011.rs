// https://leetcode.com/problems/find-if-array-can-be-sorted/description/
pub fn can_sort_array(nums: Vec<i32>) -> bool {
    let mut sorted_nums = nums.clone();
    sorted_nums.sort();
    let sorted_nums: Vec<(i32, u32)> = sorted_nums.iter().map(|n| (*n, n.count_ones())).collect();
    let mut nums: Vec<(i32, u32)> = nums.iter().map(|n| (*n, n.count_ones())).collect();
    let mut i = 0;
    while i < nums.len() {
        let mut j = i;
        while j < nums.len() && nums[i].1 == nums[j].1 {
            j += 1;
        }
        nums[i..j].sort();
        i += 1;
    }
    sorted_nums == nums
}

fn main() {
    println!("{}", can_sort_array(vec![8, 4, 2, 30, 15])); // true
    println!("{}", can_sort_array(vec![1, 2, 3, 4, 5])); // true
    println!("{}", can_sort_array(vec![3, 16, 8, 4, 2])); // false
    println!("{}", can_sort_array(vec![16, 8, 4, 2])); // true
    println!("{}", can_sort_array(vec![16, 3])); // false
    println!("{}", can_sort_array(vec![16])); // true
}
