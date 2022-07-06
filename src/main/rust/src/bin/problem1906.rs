// https://leetcode.com/problems/minimum-absolute-difference-queries/
pub fn min_difference(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
    let mut prefix = vec![vec![0; 101]; 100001];
    for i in 0..nums.len() {
        let j = nums[i] as usize;
        prefix[i][j] += 1;
        if i > 0 {
            for j in 1..101 {
                prefix[i][j] += prefix[i - 1][j];
            }
        }
    }
    let mut answer: Vec<i32> = vec![];
    for query in queries.iter() {
        let left = query[0] as usize;
        let right = query[1] as usize;
        let mut counts = vec![0; 101];
        for i in 0..101 {
            if left == 0 {
                counts[i] = prefix[right][i];
            } else {
                counts[i] = prefix[right][i] - prefix[left - 1][i];
            }
        }
        let mut min = i32::MAX;
        let mut prev = 0;
        for i in 0..101 {
            if counts[i] == 0 {
                continue;
            }
            if prev > 0 {
                min = min.min((i as i32 - prev).abs());
            }
            prev = i as i32;
        }
        answer.push(if min == i32::MAX { -1 } else { min });
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        min_difference(
            vec![1, 3, 4, 8],
            vec![vec![0, 1], vec![1, 2], vec![2, 3], vec![0, 3]]
        )
    ); // [2,1,4,1]
    println!(
        "{:?}",
        min_difference(
            vec![4, 5, 2, 2, 7, 10],
            vec![vec![2, 3], vec![0, 2], vec![0, 5], vec![3, 5]]
        )
    ); // [-1,1,1,3]
    println!("{:?}", min_difference(vec![1, 3, 3, 1], vec![vec![0, 3]])); // [2]
    println!("{:?}", min_difference(vec![3, 3, 3, 1], vec![vec![0, 3]])); // [2]
    println!("{:?}", min_difference(vec![3, 3, 3, 3], vec![vec![0, 3]])); // [-1]
}
