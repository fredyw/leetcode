// https://leetcode.com/problems/longest-uploaded-prefix/
struct LUPrefix {}

impl LUPrefix {
    fn new(n: i32) -> Self {
        todo!()
    }

    fn upload(&self, video: i32) {
        todo!()
    }

    fn longest(&self) -> i32 {
        todo!()
    }
}

fn main() {
    let server = LUPrefix::new(4);
    server.upload(3);
    println!("{}", server.longest()); // 0
    server.upload(1);
    println!("{}", server.longest()); // 1.
    server.upload(2);
    println!("{}", server.longest()); // 3
}
