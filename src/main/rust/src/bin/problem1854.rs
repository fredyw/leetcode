use std::collections::HashMap;

// https://leetcode.com/problems/maximum-population-year/description/
pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for log in logs.iter() {
        let birth = log[0];
        let death = log[1];
        *map.entry(birth).or_insert(0) += 1;
        *map.entry(death).or_insert(0) -= 1;
    }
    let mut v: Vec<(i32, i32)> = map.into_iter().collect();
    v.sort();
    let mut answer = 0;
    let mut max = 0;
    let mut prefix_sum = 0;
    for i in 0..v.len() {
        if i == 0 {
            answer = v[i].0;
            prefix_sum = v[i].1;
            max = prefix_sum;
        } else {
            prefix_sum += v[i].1;
        }
        if max < prefix_sum {
            answer = v[i].0;
            max = prefix_sum;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        maximum_population(vec![vec![1993, 1999], vec![2000, 2010]])
    ); // 1993
    println!(
        "{}",
        maximum_population(vec![vec![1950, 1961], vec![1960, 1971], vec![1970, 1981]])
    ); // 1960
}
