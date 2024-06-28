// https://leetcode.com/problems/count-triplets-with-even-xor-set-bits-i/description/
pub fn triplet_count(a: Vec<i32>, b: Vec<i32>, c: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in a.iter() {
        for j in b.iter() {
            for k in c.iter() {
                if (*i ^ *j ^ *k).count_ones() % 2 == 0 {
                    answer += 1;
                }
            }
        }
    }
    answer
}

fn main() {
    println!("{}", triplet_count(vec![1], vec![2], vec![3])); // 1
    println!("{}", triplet_count(vec![1, 1], vec![2, 3], vec![1, 5])); // 4
}
