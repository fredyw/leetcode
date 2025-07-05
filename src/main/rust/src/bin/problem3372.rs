// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/
pub fn max_target_nodes(edges1: Vec<Vec<i32>>, edges2: Vec<Vec<i32>>, k: i32) -> Vec<i32> {
    fn count(graph: &Vec<Vec<i32>>, node: usize, k: i32, visited: &mut Vec<bool>) -> i32 {
        if k == 0 {
            return 0;
        }
        let mut c = 0;
        visited[node] = true;
        for adj in graph[node].iter() {
            if !visited[*adj as usize] {
                c += count(graph, *adj as usize, k - 1, visited) + 1;
            }
        }
        c
    }

    let n = *edges1.iter().flat_map(|v| v.iter().max()).max().unwrap() as usize + 1;
    if k == 0 {
        return vec![1; n];
    }
    let m = *edges2.iter().flat_map(|v| v.iter().max()).max().unwrap() as usize + 1;
    let mut graph1: Vec<Vec<i32>> = vec![vec![]; n];
    for edge in edges1 {
        graph1[edge[0] as usize].push(edge[1]);
        graph1[edge[1] as usize].push(edge[0]);
    }
    let mut counts1: Vec<i32> = vec![0; graph1.len()];
    for node in 0..graph1.len() {
        counts1[node] = count(&graph1, node, k, &mut vec![false; n]) + 1;
    }
    let mut graph2: Vec<Vec<i32>> = vec![vec![]; m];
    for edge in edges2 {
        graph2[edge[0] as usize].push(edge[1]);
        graph2[edge[1] as usize].push(edge[0]);
    }
    let mut counts2: Vec<i32> = vec![0; graph2.len()];
    for node in 0..graph2.len() {
        counts2[node] = count(&graph2, node, k - 1, &mut vec![false; m]) + 1;
    }
    let mut answer: Vec<i32> = vec![0; counts1.len()];
    for (i, c1) in counts1.iter().enumerate() {
        let mut max = 0;
        for (_, c2) in counts2.iter().enumerate() {
            max = max.max(*c1 + *c2);
        }
        answer[i] = max;
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        max_target_nodes(
            vec![vec![0, 1], vec![0, 2], vec![2, 3], vec![2, 4]],
            vec![
                vec![0, 1],
                vec![0, 2],
                vec![0, 3],
                vec![2, 7],
                vec![1, 4],
                vec![4, 5],
                vec![4, 6]
            ],
            2
        )
    ); // [9,7,9,8,8]
    println!(
        "{:?}",
        max_target_nodes(
            vec![vec![0, 1], vec![0, 2], vec![0, 3], vec![0, 4]],
            vec![vec![0, 1], vec![1, 2], vec![2, 3]],
            1
        )
    ); // [6,3,3,3,3]
    println!(
        "{:?}",
        max_target_nodes(vec![vec![0, 1]], vec![vec![0, 1]], 0)
    ); // [1,1]
}
