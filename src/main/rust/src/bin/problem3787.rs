// https://leetcode.com/problems/find-diameter-endpoints-of-a-tree/description/
pub fn find_special_nodes(n: i32, edges: Vec<Vec<i32>>) -> String {
    fn dfs(
        graph: &Vec<Vec<i32>>,
        root: usize,
        visited: &mut Vec<bool>,
        length: i32,
        lengths: &mut Vec<i32>,
    ) {
        lengths[root] = length;
        visited[root] = true;
        for adj in &graph[root] {
            if !visited[*adj as usize] {
                dfs(graph, *adj as usize, visited, length + 1, lengths);
            }
        }
    }

    let mut graph: Vec<Vec<i32>> = vec![vec![]; n as usize];
    for edge in edges {
        graph[edge[0] as usize].push(edge[1]);
        graph[edge[1] as usize].push(edge[0]);
    }
    let mut lengths: Vec<i32> = vec![0; n as usize];
    // Find an extreme point and a diameter.
    dfs(&graph, 0, &mut vec![false; n as usize], 0, &mut lengths);
    let (_, i) = lengths
        .into_iter()
        .enumerate()
        .map(|(i, length)| (length, i))
        .max()
        .unwrap();
    let mut lengths_1: Vec<i32> = vec![0; n as usize];
    dfs(&graph, i, &mut vec![false; n as usize], 0, &mut lengths_1);
    let (&diameter, i) = lengths_1
        .iter()
        .enumerate()
        .map(|(i, length)| (length, i))
        .max()
        .unwrap();
    let mut lengths_2: Vec<i32> = vec![0; n as usize];
    dfs(&graph, i, &mut vec![false; n as usize], 0, &mut lengths_2);
    let mut answer: Vec<char> = Vec::new();
    for i in 0..n as usize {
        if lengths_1[i] == diameter || lengths_2[i] == diameter {
            answer.push('1');
        } else {
            answer.push('0');
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
