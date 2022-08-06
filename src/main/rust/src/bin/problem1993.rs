// https://leetcode.com/problems/operations-on-tree/
struct LockingTree {}

/**
 * `&self` means the method takes an immutable reference
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl LockingTree {
    fn new(parent: Vec<i32>) -> Self {
        LockingTree {}
    }

    fn lock(&self, num: i32, user: i32) -> bool {
        todo!()
    }

    fn unlock(&self, num: i32, user: i32) -> bool {
        todo!()
    }

    fn upgrade(&self, num: i32, user: i32) -> bool {
        todo!()
    }
}

fn main() {
    let tree = LockingTree::new(vec![-1, 0, 0, 1, 1, 2, 2]);
    println!("{}", tree.lock(2, 2)); // true
    println!("{}", tree.unlock(2, 3)); // false
    println!("{}", tree.unlock(2, 2)); // true
    println!("{}", tree.lock(4, 5)); // true
    println!("{}", tree.upgrade(0, 1)); // true
    println!("{}", tree.lock(0, 1)); // false
}
