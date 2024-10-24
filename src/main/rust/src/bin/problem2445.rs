// https://leetcode.com/problems/number-of-nodes-with-value-one/description/
pub fn number_of_nodes(n: i32, queries: Vec<i32>) -> i32 {
    fn number_of_nodes(node: usize, counts: &mut Vec<i32>, answer: &mut i32) {
        if node >= counts.len() {
            return;
        }
        let parent = node / 2;
        counts[node] += counts[parent];
        if counts[node] % 2 != 0 {
            *answer += 1;
        }
        number_of_nodes(node * 2, counts, answer);
        number_of_nodes((node * 2) + 1, counts, answer);
    }

    let mut counts: Vec<i32> = vec![0; n as usize + 1];
    for query in queries {
        counts[query as usize] += 1;
    }
    let mut answer = 0;
    number_of_nodes(1, &mut counts, &mut answer);
    answer
}

fn main() {
    println!("{}", number_of_nodes(5, vec![1, 2, 5])); // 3
    println!("{}", number_of_nodes(3, vec![2, 3, 3])); // 1
}
