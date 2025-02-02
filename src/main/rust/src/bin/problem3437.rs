// https://leetcode.com/problems/permutations-iii/
pub fn permute(n: i32) -> Vec<Vec<i32>> {
    fn permute(nums: &mut Vec<i32>, n: usize, i: usize, visited: &mut Vec<bool>) {
        if i == nums.len() {
            return;
        }
        if n == 0 {
            println!("{:?}", nums);
            return;
        }
        for j in 0..nums.len() {
            if visited[j] {
                continue;
            }
            visited[j] = true;
            nums.swap(i, j);
            permute(nums, n - 1, j + 1, visited);
            nums.swap(i, j);
            visited[j] = false;
        }
    }

    let mut nums: Vec<i32> = vec![];
    for i in 1..=n {
        nums.push(i);
    }
    let mut answer = vec![];
    let n = nums.len();
    permute(&mut nums, n, 0, &mut vec![false; n]);
    answer
}

fn main() {
    // println!("{:?}", permute(4)); // [[1,2,3,4],[1,4,3,2],[2,1,4,3],[2,3,4,1],[3,2,1,4],[3,4,1,2],[4,1,2,3],[4,3,2,1]]
    // println!("{:?}", permute(2)); // [[1,2],[2,1]]
    println!("{:?}", permute(3)); // [[1,2,3],[3,2,1]]
}
