use std::collections::HashSet;

// https://leetcode.com/problems/longest-uploaded-prefix/
struct LUPrefix {
    set: HashSet<i32>,
    longest: i32,
}

impl LUPrefix {
    fn new(n: i32) -> Self {
        LUPrefix {
            set: HashSet::new(),
            longest: 0,
        }
    }

    fn upload(&mut self, video: i32) {
        self.set.insert(video);
        while self.set.contains(&(self.longest + 1)) {
            self.longest += 1;
        }
    }

    fn longest(&self) -> i32 {
        self.longest
    }
}

fn main() {
    let mut server = LUPrefix::new(4);
    server.upload(3);
    println!("{}", server.longest()); // 0
    server.upload(1);
    println!("{}", server.longest()); // 1
    server.upload(2);
    println!("{}", server.longest()); // 3
}
