// https://leetcode.com/problems/design-a-number-container-system/
struct NumberContainers {}

impl NumberContainers {
    fn new() -> Self {
        NumberContainers {}
    }

    fn change(&mut self, index: i32, number: i32) {
        todo!()
    }

    fn find(&self, number: i32) -> i32 {
        todo!()
    }
}

fn main() {
    let mut nc = NumberContainers::new();
    println!("{}", nc.find(10)); // -1
    nc.change(2, 10);
    nc.change(1, 10);
    nc.change(3, 10);
    nc.change(5, 10);
    println!("{}", nc.find(10)); // 1
    nc.change(1, 20);
    println!("{}", nc.find(10)); // 2.
}
