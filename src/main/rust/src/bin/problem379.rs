use std::collections::HashSet;

// https://leetcode.com/problems/design-phone-directory/description/
struct PhoneDirectory {
    available: HashSet<i32>,
    assigned: HashSet<i32>,
}

impl PhoneDirectory {
    fn new(max_numbers: i32) -> Self {
        let mut available = HashSet::new();
        for i in 0..max_numbers {
            available.insert(i);
        }
        Self {
            available,
            assigned: HashSet::new(),
        }
    }

    fn get(&mut self) -> i32 {
        let val = if let Some(n) = self.available.iter().next() {
            *n
        } else {
            -1
        };
        if val != -1 {
            self.assigned.insert(val);
            self.available.remove(&val);
        }
        val
    }

    fn check(&self, number: i32) -> bool {
        self.available.contains(&number)
    }

    fn release(&mut self, number: i32) {
        self.assigned.remove(&number);
        self.available.insert(number);
    }
}

fn main() {
    let mut dir = PhoneDirectory::new(3);
    println!("{}", dir.get()); // 0
    println!("{}", dir.get()); // 1
    println!("{}", dir.check(2)); // true
    println!("{}", dir.get()); // 2
    println!("{}", dir.check(2)); // false
    dir.release(2);
    println!("{}", dir.check(2)); // true
}
