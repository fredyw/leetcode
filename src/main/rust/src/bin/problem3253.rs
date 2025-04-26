// https://leetcode.com/problems/construct-string-with-minimum-cost-easy/description/
pub fn minimum_cost(target: String, words: Vec<String>, costs: Vec<i32>) -> i32 {
    fn minimum_cost(
        target: &str,
        words: &Vec<(String, i32)>,
        index: usize,
        memo: &mut Vec<i32>,
    ) -> i32 {
        if index == target.len() {
            return 0;
        }
        if memo[index] != -1 {
            return memo[index];
        }
        let mut min_cost = i32::MAX;
        let sub = &target[index..];
        for (word, cost) in words.iter() {
            if sub.starts_with(word) {
                min_cost =
                    min_cost.min(minimum_cost(target, words, index + word.len(), memo) + *cost);
            }
        }
        memo[index] = min_cost;
        min_cost
    }

    let answer = minimum_cost(
        &target,
        &words.into_iter().zip(costs.into_iter()).collect(),
        0,
        &mut vec![-1; target.len()],
    );
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!(
        "{}",
        minimum_cost(
            "abcdef".to_string(),
            vec![
                "abdef".to_string(),
                "abc".to_string(),
                "d".to_string(),
                "def".to_string(),
                "ef".to_string()
            ],
            vec![100, 1, 1, 10, 5]
        )
    ); // 7
    println!(
        "{}",
        minimum_cost(
            "aaaa".to_string(),
            vec!["z".to_string(), "zz".to_string(), "zzz".to_string()],
            vec![1, 10, 100]
        )
    ); // -1
    println!(
        "{}",
        minimum_cost(
            "abcdef".to_string(),
            vec![
                "abcd".to_string(),
                "abc".to_string(),
                "d".to_string(),
                "def".to_string(),
                "ef".to_string()
            ],
            vec![100, 1, 1, 10, 5]
        )
    ); // 7
}
