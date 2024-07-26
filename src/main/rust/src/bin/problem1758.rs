// https://leetcode.com/problems/design-most-recently-used-queue/description/
struct MRUQueue {}

impl MRUQueue {
    fn new(n: i32) -> Self {
        MRUQueue {}
    }

    fn fetch(&self, k: i32) -> i32 {
        todo!()
    }
}

fn main() {
    let queue = MRUQueue::new(8);
    println!("{}", queue.fetch(3)); // 3
    println!("{}", queue.fetch(5)); // 6
    println!("{}", queue.fetch(2)); // 2
    println!("{}", queue.fetch(8)); // 2
}
