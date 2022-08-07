use std::collections::HashMap;

// https://leetcode.com/problems/operatigions-on-tree/
struct LockingTree {
    parent_to_children: HashMap<i32, Vec<i32>>,
    child_to_parent: HashMap<i32, i32>,
    locks: HashMap<i32, i32>,
}

/**
 * `&self` means the method takes an immutable reference
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl LockingTree {
    fn new(parent: Vec<i32>) -> Self {
        let mut parent_to_children = HashMap::new();
        let mut child_to_parent = HashMap::new();
        for (num, parent) in parent.into_iter().enumerate() {
            let children = parent_to_children.entry(parent).or_insert(vec![]);
            (*children).push(num as i32);
            child_to_parent.insert(num as i32, parent);
        }
        LockingTree {
            parent_to_children,
            child_to_parent,
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
                self.locks.remove(&num);
                true
            }
            None => false,
        }
    }

    fn upgrade(&mut self, num: i32, user: i32) -> bool {
        fn has_locked_ancestor(
            child_to_parent: &HashMap<i32, i32>,
            locks: &HashMap<i32, i32>,
            num: i32,
        ) -> bool {
            let mut parent = child_to_parent.get(&num);
            while let Some(p) = parent {
                if locks.get(p).is_some() {
                    return true;
                }
                parent = child_to_parent.get(p);
            }
            false
        }

        fn has_locked_descendent(
            parent_to_children: &HashMap<i32, Vec<i32>>,
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
            for child in parent_to_children.get(&num).unwrap_or(&vec![]).iter() {
                has_locked |= has_locked_descendent(parent_to_children, locks, *child);
            }
            has_locked
        }

        match self.locks.get(&num) {
            Some(_) => false,
            None => {
                if has_locked_ancestor(&self.child_to_parent, &self.locks, num) {
                    return false;
                }
                if !has_locked_descendent(&self.parent_to_children, &mut self.locks, num) {
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
    println!("{}", tree.lock(2, 3)); // true
    println!("{}", tree.upgrade(0, 1)); // true
    println!("{}", tree.lock(0, 1)); // false
    println!("{}", tree.unlock(0, 1)); // true
    println!("{}", tree.upgrade(3, 1)); // false
}
