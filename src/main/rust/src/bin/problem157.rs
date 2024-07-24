struct Solution {}

impl Solution {
    fn read4(&self, buf4: &mut [char]) -> i32 {
        unimplemented!()
    }

    // https://leetcode.com/problems/read-n-characters-given-read4/description/
    pub fn read(&self, buf: &mut [char], n: i32) -> i32 {
        let mut answer = 0;
        let mut n = n;
        let mut i = 0;
        while n > 0 {
            let m = self.read4(&mut buf[i..i + 4]);
            answer += m.min(n);
            if m < 4 {
                break;
            }
            i += m as usize;
            n -= m;
        }
        answer
    }
}

fn main() {}
