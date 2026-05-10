// https://leetcode.com/problems/first-unique-number/description/
struct FirstUnique {}

impl FirstUnique {
    fn new(nums: Vec<i32>) -> Self {
        todo!()
    }

    fn show_first_unique(&self) -> i32 {
        todo!()
    }

    fn add(&self, value: i32) {
        todo!()
    }
}

fn main() {
    let first_unique = FirstUnique::new(vec![2, 3, 5]);
    println!("{}", first_unique.show_first_unique()); // 2
    first_unique.add(5);
    println!("{}", first_unique.show_first_unique()); // 2
    first_unique.add(2);
    println!("{}", first_unique.show_first_unique()); // 3
    first_unique.add(3);
    println!("{}", first_unique.show_first_unique()); // -1

    let first_unique = FirstUnique::new(vec![7, 7, 7, 7, 7, 7]);
    println!("{}", first_unique.show_first_unique()); // -1
    first_unique.add(7);
    first_unique.add(3);
    first_unique.add(3);
    first_unique.add(7);
    first_unique.add(17);
    println!("{}", first_unique.show_first_unique()); // 17

    let first_unique = FirstUnique::new(vec![809]);
    println!("{}", first_unique.show_first_unique()); // 809
    first_unique.add(809);
    println!("{}", first_unique.show_first_unique()); // -1
}
