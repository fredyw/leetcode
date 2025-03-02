use std::collections::HashMap;

// https://leetcode.com/problems/parallel-courses/
pub fn minimum_semesters(n: i32, relations: Vec<Vec<i32>>) -> i32 {
    let mut graph: HashMap<i32, Vec<i32>> = HashMap::new();
    let mut in_degrees: HashMap<i32, i32> = HashMap::new();
    for i in 1..=n {
        graph.insert(i, vec![]);
        in_degrees.insert(i, 0);
    }
    for relation in relations.iter() {
        let from = relation[0];
        let to = relation[1];
        graph.entry(from).or_insert(vec![]).push(to);
    }
    for relation in relations {
        let to = relation[1];
        *in_degrees.entry(to).or_insert(0) += 1;
    }
    let mut answer = 0;
    while !graph.is_empty() {
        let mut to_be_removed: Vec<i32> = vec![];
        let mut to_be_updated: Vec<i32> = vec![];
        let mut has_removal = false;
        for (node, count) in in_degrees.iter_mut() {
            if *count == 0 {
                for adj in graph.get(node).unwrap_or(&vec![]) {
                    to_be_updated.push(*adj);
                }
                to_be_removed.push(*node);
                graph.remove(node);
                has_removal = true;
            }
        }
        // Has cycle.
        if !has_removal {
            return -1;
        }
        for node in to_be_removed {
            in_degrees.remove(&node);
        }
        for node in to_be_updated {
            *in_degrees.entry(node).or_insert(0) -= 1;
        }
        answer += 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_semesters(3, vec![vec![1, 3], vec![2, 3]])); // 2
    println!(
        "{}",
        minimum_semesters(3, vec![vec![1, 2], vec![2, 3], vec![3, 1]])
    ); // -1
    println!(
        "{}",
        minimum_semesters(3, vec![vec![1, 2], vec![2, 3], vec![3, 1], vec![4, 1]])
    ); // -1
    println!("{}", minimum_semesters(3, vec![vec![1, 2], vec![2, 3]])); // 3
    println!(
        "{}",
        minimum_semesters(4, vec![vec![1, 3], vec![2, 3], vec![3, 4], vec![1, 4]])
    ); // 3
    println!(
        "{}",
        minimum_semesters(4, vec![vec![1, 2], vec![3, 4], vec![4, 3]])
    ); // -1
}
