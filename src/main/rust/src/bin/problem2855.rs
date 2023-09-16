// https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/description/
pub fn minimum_right_shifts(nums: Vec<i32>) -> i32 {
    let min = nums.iter().min().copied().unwrap();
    let mut min_index = 0;
    for (i, num) in nums.iter().enumerate() {
        if *num == min {
            min_index = i;
            break;
        }
    }
    let mut i = min_index;
    let mut len = 0;
    while len < nums.len() - 1 {
        let j = (i + 1) % nums.len();
        if nums[i] >= nums[j] {
            return -1;
        }
        len += 1;
        i = (i + 1) % nums.len();
    }
    if min_index == 0 {
        0
    } else {
        (nums.len() - min_index) as i32
    }
}

fn main() {
    println!("{}", minimum_right_shifts(vec![3, 4, 5, 1, 2])); // 2
    println!("{}", minimum_right_shifts(vec![1, 3, 5])); // 0
    println!("{}", minimum_right_shifts(vec![2, 1, 4])); // -1
}
