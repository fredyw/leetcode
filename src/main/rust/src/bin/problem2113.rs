// https://leetcode.com/problems/elements-in-array-after-removing-and-replacing-elements/description/
pub fn element_in_nums(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
    let mut new_nums: Vec<&[i32]> = vec![];
    let mut i = 0;
    let mut remove = true;
    for _ in 0..nums.len() * 2 {
        if remove {
            new_nums.push(&nums[i..nums.len()]);
            if i == nums.len() {
                remove = false;
                i = 0;
            }
        } else {
            new_nums.push(&nums[0..i]);
        }
        i += 1;
    }
    let mut answer = vec![];
    for query in queries {
        let time = (query[0] as usize) % new_nums.len();
        let index = query[1] as usize;
        answer.push(*new_nums.get(time).unwrap().get(index).unwrap_or(&-1));
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        element_in_nums(
            vec![0, 1, 2],
            vec![vec![0, 2], vec![2, 0], vec![3, 2], vec![5, 0]]
        )
    ); // [2,2,-1,0]
    println!(
        "{:?}",
        element_in_nums(
            vec![2],
            vec![vec![0, 0], vec![1, 0], vec![2, 0], vec![3, 0]]
        )
    ); // [2,-1,2,-1]
    println!(
        "{:?}",
        element_in_nums(
            vec![0, 1, 2],
            vec![
                vec![0, 2],
                vec![2, 0],
                vec![3, 2],
                vec![5, 0],
                vec![6, 0],
                vec![7, 0],
                vec![8, 0]
            ]
        )
    ); // [2,2,-1,0,0,1,2]
}
