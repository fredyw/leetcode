// https://leetcode.com/problems/find-diameter-endpoints-of-a-tree/description/
pub fn find_special_nodes(n: i32, edges: Vec<Vec<i32>>) -> String {
    let mut graph: Vec<Vec<i32>> = vec![vec![]; n as usize];
    for edge in edges {
        graph[edge[0] as usize].push(edge[1]);
        graph[edge[1] as usize].push(edge[0]);
    }
    let mut answer: Vec<char> = vec!['0'; n as usize];
    for (i, v) in graph.into_iter().enumerate() {
        if v.len() == 1 {
            answer[i] = '1';
        }
    }
    answer.into_iter().collect()
}

fn main() {
    println!("{}", find_special_nodes(3, vec![vec![0, 1], vec![1, 2]])); // "101"
    println!(
        "{}",
        find_special_nodes(
            7,
            vec![
                vec![0, 1],
                vec![1, 2],
                vec![2, 3],
                vec![3, 4],
                vec![3, 5],
                vec![1, 6]
            ]
        )
    ); // "1000111"
    println!("{}", find_special_nodes(2, vec![vec![0, 1]])); // "11"
    println!(
        "{}",
        find_special_nodes(
            6,
            vec![vec![1, 5], vec![3, 2], vec![2, 5], vec![4, 0], vec![0, 5]]
        )
    ); // "000110"
}
