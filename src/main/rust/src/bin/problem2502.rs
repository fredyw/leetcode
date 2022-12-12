// https://leetcode.com/problems/design-memory-allocator/
struct Allocator {}

impl Allocator {
    fn new(n: i32) -> Self {
        todo!()
    }

    fn allocate(&self, size: i32, m_id: i32) -> i32 {
        todo!()
    }

    fn free(&self, m_id: i32) -> i32 {
        todo!()
    }
}

fn main() {
    let allocator = Allocator::new(10);
    println!("{}", allocator.allocate(1, 1)); // 0
    println!("{}", allocator.allocate(1, 2)); // 1
    println!("{}", allocator.allocate(1, 3)); // 2
    println!("{}", allocator.free(2)); // 1
    println!("{}", allocator.allocate(3, 4)); // 3
    println!("{}", allocator.allocate(1, 1)); // 1
    println!("{}", allocator.allocate(1, 1)); // 6
    println!("{}", allocator.free(1)); // 3
    println!("{}", allocator.allocate(10, 2)); // -1
    println!("{}", allocator.free(7)); // 0
}
