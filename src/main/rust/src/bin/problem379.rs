// https://leetcode.com/problems/design-phone-directory/description/
struct PhoneDirectory {}

impl PhoneDirectory {
    fn new(maxNumbers: i32) -> Self {
        Self {}
    }

    fn get(&self) -> i32 {
        todo!()
    }

    fn check(&self, number: i32) -> bool {
        todo!()
    }

    fn release(&self, number: i32) {
        todo!()
    }
}

fn main() {
    let dir = PhoneDirectory::new(3);
    println!("{}", dir.get()); // 0
    println!("{}", dir.get()); // 1
    println!("{}", dir.check(2)); // true
    println!("{}", dir.get()); // 2
    println!("{}", dir.check(2)); // false
    dir.release(2);
    println!("{}", dir.check(2)); // true
}
