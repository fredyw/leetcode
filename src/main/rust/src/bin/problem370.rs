// https://leetcode.com/problems/range-addition/description/
pub fn get_modified_array(length: i32, updates: Vec<Vec<i32>>) -> Vec<i32> {
    let mut answer: Vec<i32> = vec![0; length as usize];
    for update in updates {
        let from = update[0] as usize;
        let to = update[1] as usize;
        let val = update[2];
        answer[from] += val;
        if to < length as usize - 1 {
            answer[to + 1] -= val;
        }
    }
    for i in 0..length as usize {
        if i > 0 {
            answer[i] += answer[i - 1];
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        get_modified_array(5, vec![vec![1, 3, 2], vec![2, 4, 3], vec![0, 2, -2]])
    ); // [-2,0,3,5,3]
    println!(
        "{:?}",
        get_modified_array(10, vec![vec![2, 4, 6], vec![5, 6, 8], vec![1, 9, -4]])
    ); // [0,-4,2,2,2,4,4,-4,-4,-4]
}
