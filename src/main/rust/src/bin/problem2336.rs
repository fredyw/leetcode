// https://leetcode.com/problems/smallest-number-in-infinite-set/
struct SmallestInfiniteSet {}

impl SmallestInfiniteSet {
    fn new() -> Self {
        todo!()
    }

    fn pop_smallest(&self) -> i32 {
        todo!()
    }

    fn add_back(&self, num: i32) {
        todo!()
    }
}

fn main() {
    let s = SmallestInfiniteSet::new();
    s.add_back(2);
    println!("{}", s.pop_smallest()); // 1
    println!("{}", s.pop_smallest()); // 2
    println!("{}", s.pop_smallest()); // 3
    s.add_back(1);
    println!("{}", s.pop_smallest()); // 1
    println!("{}", s.pop_smallest()); // 4
}
