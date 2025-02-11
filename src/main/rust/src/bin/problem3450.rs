use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/maximum-students-on-a-single-bench/description/
pub fn max_students_on_bench(students: Vec<Vec<i32>>) -> i32 {
    let mut map: HashMap<i32, HashSet<i32>> = HashMap::new();
    for s in students.iter() {
        let student = s[0];
        let bench = s[1];
        map.entry(bench).or_insert(HashSet::new()).insert(student);
    }
    let mut answer = 0;
    for (_, set) in map.iter() {
        answer = answer.max(set.len() as i32);
    }
    answer
}

fn main() {
    println!(
        "{}",
        max_students_on_bench(vec![
            vec![1, 2],
            vec![2, 2],
            vec![3, 3],
            vec![1, 3],
            vec![2, 3]
        ])
    ); // 3
    println!(
        "{}",
        max_students_on_bench(vec![
            vec![1, 1],
            vec![2, 1],
            vec![3, 1],
            vec![4, 2],
            vec![5, 2]
        ])
    ); // 3
    println!("{}", max_students_on_bench(vec![vec![1, 1], vec![1, 1]])); // 1
    println!("{}", max_students_on_bench(vec![])); // 0
}
