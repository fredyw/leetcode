use std::collections::HashMap;

// https://leetcode.com/problems/operations-on-tree/
struct LockingTree {
    tree: HashMap<i32, Vec<i32>>,
    locks: HashMap<i32, i32>,
}

/**
 * `&self` means the method takes an immutable reference
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl LockingTree {
    fn new(parent: Vec<i32>) -> Self {
        let mut tree = HashMap::new();
        for (num, parent) in parent.into_iter().enumerate() {
            let children = tree.entry(parent).or_insert(vec![]);
            (*children).push(num as i32);
        }
        LockingTree {
            tree,
            locks: HashMap::new(),
        }
    }

    fn lock(&mut self, num: i32, user: i32) -> bool {
        match self.locks.get(&num) {
            Some(_) => false,
            None => {
                self.locks.insert(num, user);
                true
            }
        }
    }

    fn unlock(&mut self, num: i32, user: i32) -> bool {
        match self.locks.get(&num) {
            Some(u) => {
                if user != *u {
                    return false;
                }
                self.locks.insert(num, user);
                true
            }
            None => false,
        }
    }

    fn upgrade(&mut self, num: i32, user: i32) -> bool {
        match self.locks.get(&num) {
            Some(_) => false,
            None => {
                todo!()
            }
        }
    }
}

fn main() {
    let mut tree = LockingTree::new(vec![-1, 0, 0, 1, 1, 2, 2]);
    println!("{}", tree.lock(2, 2)); // true
    println!("{}", tree.unlock(2, 3)); // false
    println!("{}", tree.unlock(2, 2)); // true
    println!("{}", tree.lock(4, 5)); // true
    println!("{}", tree.upgrade(0, 1)); // true
    println!("{}", tree.lock(0, 1)); // false
    println!("{}", tree.upgrade(3, 1)); // false
}
