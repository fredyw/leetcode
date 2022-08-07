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
        fn has_locked_ancestor(
            tree: &HashMap<i32, Vec<i32>>,
            locks: &HashMap<i32, i32>,
            num_target: i32,
            num: i32,
            locked: bool,
        ) -> bool {
            if num == num_target {
                return locked;
            }
            let mut has_locked = match locks.get(&num) {
                Some(_) => true,
                None => false,
            };
            for child in tree.get(&num).unwrap_or(&vec![]).iter() {
                has_locked |= has_locked_ancestor(tree, locks, num_target, *child, has_locked);
            }
            has_locked
        }

        fn has_locked_descendent(
            tree: &HashMap<i32, Vec<i32>>,
            locks: &mut HashMap<i32, i32>,
            num: i32,
        ) -> bool {
            let mut has_locked = match locks.get(&num) {
                Some(_) => {
                    locks.remove(&num);
                    true
                }
                None => false,
            };
            for child in tree.get(&num).unwrap_or(&vec![]).iter() {
                has_locked |= has_locked_descendent(tree, locks, *child);
            }
            has_locked
        }

        match self.locks.get(&num) {
            Some(_) => false,
            None => {
                if has_locked_ancestor(&self.tree, &self.locks, num, 0, false) {
                    return false;
                }
                if !has_locked_descendent(&self.tree, &mut self.locks, num) {
                    return false;
                }
                self.locks.insert(num, user);
                true
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
