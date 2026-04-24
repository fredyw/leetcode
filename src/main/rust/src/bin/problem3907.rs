// https://leetcode.com/problems/count-smaller-elements-with-opposite-parity/description/
pub fn count_smaller_opposite_parity(nums: Vec<i32>) -> Vec<i32> {
    fn get_rank(sorted_unique: &Vec<i32>, val: i32) -> usize {
        sorted_unique.binary_search(&val).unwrap() + 1
    }

    fn update(bit: &mut Vec<i32>, mut idx: usize, delta: i32) {
        while idx < bit.len() {
            bit[idx] += delta;
            idx += (idx as i32 & -(idx as i32)) as usize;
        }
    }

    fn query(bit: &Vec<i32>, mut idx: usize) -> i32 {
        let mut sum = 0;
        while idx > 0 {
            sum += bit[idx];
            idx -= (idx as i32 & -(idx as i32)) as usize;
        }
        sum
    }

    let mut sorted_unique = nums.clone();
    sorted_unique.sort_unstable();
    sorted_unique.dedup();
    let mut even_bit = vec![0; sorted_unique.len() + 1];
    let mut odd_bit = vec![0; sorted_unique.len() + 1];
    let mut answer = vec![0; nums.len()];
    for i in (0..nums.len()).rev() {
        let rank = get_rank(&sorted_unique, nums[i]);
        if nums[i] % 2 == 0 {
            answer[i] = query(&odd_bit, rank - 1);
            update(&mut even_bit, rank, 1);
        } else {
            answer[i] = query(&even_bit, rank - 1);
            update(&mut odd_bit, rank, 1);
        }
    }
    answer
}

fn main() {
    println!("{:?}", count_smaller_opposite_parity(vec![5, 2, 4, 1, 3])); // [2,1,2,0,0]
    println!("{:?}", count_smaller_opposite_parity(vec![4, 4, 1])); // [1,1,0]
    println!("{:?}", count_smaller_opposite_parity(vec![7])); // [0]
}
