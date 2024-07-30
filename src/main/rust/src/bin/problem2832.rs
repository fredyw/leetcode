use std::collections::VecDeque;

// https://leetcode.com/problems/maximal-range-that-each-element-is-maximum-in-it/
pub fn maximum_length_of_ranges(nums: Vec<i32>) -> Vec<i32> {
    let mut forward: Vec<i32> = vec![-1; nums.len()];
    let mut deque: VecDeque<usize> = VecDeque::new();
    for i in 0..nums.len() {
        while let Some(index) = deque.back() {
            if nums[*index] > nums[i] {
                break;
            }
            forward[*index] = i as i32;
            deque.pop_back();
        }
        deque.push_back(i);
    }
    let mut backward: Vec<i32> = vec![-1; nums.len()];
    let mut deque: VecDeque<usize> = VecDeque::new();
    for i in (0..nums.len()).rev() {
        while let Some(index) = deque.back() {
            if nums[*index] > nums[i] {
                break;
            }
            backward[*index] = i as i32;
            deque.pop_back();
        }
        deque.push_back(i);
    }
    let mut answer = vec![0; nums.len()];
    for i in 0..answer.len() {
        let right_length = if forward[i] == -1 {
            (answer.len() - i) as i32
        } else {
            forward[i] - i as i32
        };
        let left_length = if backward[i] == -1 {
            i as i32
        } else {
            i as i32 - (backward[i] + 1)
        };
        answer[i] = left_length + right_length;
    }
    answer
}

fn main() {
    println!("{:?}", maximum_length_of_ranges(vec![1, 5, 4, 3, 6])); // [1,4,2,1,5]
    println!("{:?}", maximum_length_of_ranges(vec![1, 2, 3, 4, 5])); // [1,2,3,4,5]
    println!("{:?}", maximum_length_of_ranges(vec![1, 5, 2, 4, 3])); // [1,5,1,3,1]
}
