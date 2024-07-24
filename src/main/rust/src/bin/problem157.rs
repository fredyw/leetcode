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
            let mut buf4 = [' ', ' ', ' ', ' '];
            let m = self.read4(&mut buf4);
            answer += m.min(n);
            for j in 0..m.min(n) as usize {
                buf[i] = buf4[j];
                i += 1;
            }
            if m < 4 {
                break;
            }
            n -= m;
        }
        answer
    }
}

fn main() {}
