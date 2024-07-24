struct Solution {}

impl Solution {
    fn read4(&self, buf4: &mut [char]) -> i32 {
        unimplemented!()
    }

    // https://leetcode.com/problems/read-n-characters-given-read4/description/
    pub fn read(&self, buf: &mut [char], n: i32) -> i32 {
        while self.read4(buf) > 0 {}
        n
    }
}

fn main() {}
