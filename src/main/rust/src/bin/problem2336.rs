use std::collections::BTreeSet;

// https://leetcode.com/problems/smallest-number-in-infinite-set/
struct SmallestInfiniteSet {
    lowest: i32,
    tree: BTreeSet<i32>,
}

impl SmallestInfiniteSet {
    fn new() -> Self {
        SmallestInfiniteSet {
            lowest: 1,
            tree: BTreeSet::new(),
        }
    }

    fn pop_smallest(&mut self) -> i32 {
        if self.tree.is_empty() {
            let lowest = self.lowest;
            self.lowest += 1;
            return lowest;
        }
        let first = self.tree.iter().next().unwrap().clone();
        self.tree.remove(&first);
        first
    }

    fn add_back(&mut self, num: i32) {
        if num < self.lowest {
            self.tree.insert(num);
        }
    }
}

fn main() {
    let mut s = SmallestInfiniteSet::new();
    s.add_back(2);
    println!("{}", s.pop_smallest()); // 1
    println!("{}", s.pop_smallest()); // 2
    println!("{}", s.pop_smallest()); // 3
    s.add_back(1);
    println!("{}", s.pop_smallest()); // 1
    println!("{}", s.pop_smallest()); // 4
}
