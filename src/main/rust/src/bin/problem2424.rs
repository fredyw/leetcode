use std::collections::BTreeSet;
use std::ops::Bound::Included;

// https://leetcode.com/problems/longest-uploaded-prefix/
struct LUPrefix {}

impl LUPrefix {
    fn new(n: i32) -> Self {
        LUPrefix {}
    }

    fn upload(&mut self, video: i32) {
        todo!()
    }

    fn longest(&self) -> i32 {
        todo!()
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
