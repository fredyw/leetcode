// https://leetcode.com/problems/permutations-iii/
pub fn permute(n: i32) -> Vec<Vec<i32>> {
    fn permute(nums: &mut Vec<i32>) -> Vec<Vec<i32>> {
        todo!()
    }

    let mut nums: Vec<i32> = vec![];
    for i in 1..=n {
        nums.push(i);
    }
    permute(&mut nums)
}

fn main() {
    println!("{:?}", permute(4)); // [[1,2,3,4],[1,4,3,2],[2,1,4,3],[2,3,4,1],[3,2,1,4],[3,4,1,2],[4,1,2,3],[4,3,2,1]]
    println!("{:?}", permute(2)); // [[1,2],[2,1]]
    println!("{:?}", permute(3)); // [[1,2,3],[3,2,1]]
}
