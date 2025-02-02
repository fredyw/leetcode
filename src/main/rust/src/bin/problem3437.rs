// https://leetcode.com/problems/permutations-iii/
pub fn permute(n: i32) -> Vec<Vec<i32>> {
    fn permute(
        nums: &mut Vec<i32>,
        visited: &mut Vec<bool>,
        accu: &mut Vec<i32>,
        permutations: &mut Vec<Vec<i32>>,
    ) {
        if accu.len() == nums.len() {
            permutations.push(accu.clone());
            return;
        }
        for j in 0..nums.len() {
            if visited[j] {
                continue;
            }
            if let Some(last) = accu.last() {
                if last % 2 == 0 && nums[j] % 2 == 0 {
                    continue;
                }
                if last % 2 != 0 && nums[j] % 2 != 0 {
                    continue;
                }
            }
            visited[j] = true;
            accu.push(nums[j]);
            permute(nums, visited, accu, permutations);
            accu.pop();
            visited[j] = false;
        }
    }

    let mut nums: Vec<i32> = vec![];
    for i in 1..=n {
        nums.push(i);
    }
    let mut answer = vec![];
    let n = nums.len();
    permute(&mut nums, &mut vec![false; n], &mut vec![], &mut answer);
    answer
}

fn main() {
    println!("{:?}", permute(4)); // [[1,2,3,4],[1,4,3,2],[2,1,4,3],[2,3,4,1],[3,2,1,4],[3,4,1,2],[4,1,2,3],[4,3,2,1]]
    println!("{:?}", permute(2)); // [[1,2],[2,1]]
    println!("{:?}", permute(3)); // [[1,2,3],[3,2,1]]
}
