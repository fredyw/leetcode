// https://leetcode.com/problems/number-of-equal-numbers-blocks/description/
struct BigArray {}
impl BigArray {
    pub fn new(elements: Vec<i32>) -> Self {
        unimplemented!();
    }

    pub fn at(&self, size: usize) -> i32 {
        unimplemented!();
    }

    pub fn size(&self) -> usize {
        unimplemented!();
    }
}

pub fn count_blocks(nums: BigArray) -> i32 {
    let mut answer = 0;
    let mut count = 0;
    for i in 0..nums.size() - 1 {
        if nums.at(i) != nums.at(i + 1) {
            count = 1;
            answer += 1;
        } else {
            count += 1;
        }
    }
    answer
}

fn main() {}
