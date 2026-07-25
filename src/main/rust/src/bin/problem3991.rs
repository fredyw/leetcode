use std::collections::HashSet;

// https://leetcode.com/problems/sort-array-using-prefix-reversals/description/
pub fn sort_array(mut nums: Vec<i32>, pre: Vec<i32>) -> i32 {
    let pre: HashSet<i32> = pre.into_iter().collect();
    let mut answer = 0;
    for i in 0..nums.len() {
        let mut possible = false;
        if nums[i] != i as i32 {
            for j in pre.iter() {
                let j = *j as usize;
                if i + j - 1 >= nums.len() {
                    continue;
                }
                if nums[i + j - 1] == i as i32 {
                    nums[i..i + j].reverse();
                    answer += 1;
                    possible = true;
                    break;
                }
            }
        } else {
            possible = true;
        }
        println!("nums: {:?}", nums);
        if !possible {
            return -1;
        }
    }
    answer
}

fn main() {
    // println!("{}", sort_array(vec![2, 0, 1], vec![2, 3])); // 2
    // println!("{}", sort_array(vec![1, 0, 2], vec![1, 3])); // -1
    // println!("{}", sort_array(vec![0, 1], vec![2])); // 0
    println!("{}", sort_array(vec![0, 2, 1], vec![3, 2, 1])); // 3
}
