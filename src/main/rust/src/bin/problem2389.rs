// https://leetcode.com/problems/longest-subsequence-with-limited-sum/
pub fn answer_queries(mut nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
    let mut answer: Vec<i32> = vec![];
    nums.sort();
    let mut prefix_sums: Vec<i32> = vec![0; nums.len()];
    for (i, num) in nums.iter().enumerate() {
        if i == 0 {
            prefix_sums[i] = *num;
        } else {
            prefix_sums[i] = prefix_sums[i - 1] + num;
        }
    }
    for query in queries.into_iter() {
        match prefix_sums.binary_search(&query) {
            Ok(i) => answer.push((i + 1) as i32),
            Err(i) => answer.push(i as i32),
        }
    }
    answer
}

fn main() {
    println!("{:?}", answer_queries(vec![4, 5, 2, 1], vec![3, 10, 21])); // [2,3,4]
    println!("{:?}", answer_queries(vec![2, 3, 4, 5], vec![1])); // [0]
}
