// https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/
pub fn color_the_array(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
    let mut answer = vec![0; queries.len()];
    let mut nums = vec![0; n as usize];
    let mut total_count = 0;
    for (i, query) in queries.into_iter().enumerate() {
        let index = query[0];
        let color = query[1];
        let mut count = 0;
        if nums[index as usize] != 0 && index as usize + 1 < nums.len() {
            if nums[index as usize] == nums[index as usize + 1] {
                count += 1;
            }
        }
        if nums[index as usize] != 0 && index - 1 >= 0 {
            if nums[index as usize] == nums[index as usize - 1] {
                count += 1;
            }
        }
        total_count -= count;
        nums[index as usize] = color;
        if index as usize + 1 < nums.len() {
            if nums[index as usize] == nums[index as usize + 1] {
                total_count += 1;
            }
        }
        if index - 1 >= 0 {
            if nums[index as usize] == nums[index as usize - 1] {
                total_count += 1;
            }
        }
        answer[i] = total_count;
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        color_the_array(
            4,
            vec![vec![0, 2], vec![1, 2], vec![3, 1], vec![1, 1], vec![2, 1]]
        )
    ); // [0,1,1,0,2]
    println!("{:?}", color_the_array(1, vec![vec![0, 100000]])); // [0]
}
