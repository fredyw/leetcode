// https://leetcode.com/problems/number-of-same-end-substrings/description/
pub fn same_end_substring_count(s: String, queries: Vec<Vec<i32>>) -> Vec<i32> {
    fn nth_triangle(n: i32) -> i32 {
        n * (n + 1) / 2
    }

    let mut answer = vec![];
    let mut prefix_sum: Vec<Vec<i32>> = vec![vec![0; 26]; s.len()];
    for (i, c) in s.chars().enumerate() {
        if i > 0 {
            prefix_sum[i] = prefix_sum[i - 1].clone();
        }
        prefix_sum[i][c as usize - 'a' as usize] += 1;
    }
    for query in queries {
        let from = if query[0] == 0 {
            &vec![0; 26]
        } else {
            &prefix_sum[query[0] as usize - 1]
        };
        let to = &prefix_sum[query[1] as usize];
        let mut sum = 0;
        for i in 0..to.len() {
            sum += nth_triangle(to[i] - from[i]);
        }
        answer.push(sum);
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        same_end_substring_count(
            "abcaab".to_string(),
            vec![vec![0, 0], vec![1, 4], vec![2, 5], vec![0, 5]]
        )
    ); // [1,5,5,10]
    println!(
        "{:?}",
        same_end_substring_count("abcd".to_string(), vec![vec![0, 3]])
    ); // [4]
    println!(
        "{:?}",
        same_end_substring_count(
            "aaaabbbccd".to_string(),
            vec![vec![0, 9], vec![4, 9], vec![4, 6]]
        )
    ); // [20,10,6]
}
