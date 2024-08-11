// https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
struct TwoSum {}

impl TwoSum {
    fn new() -> Self {
        TwoSum {}
    }

    fn add(&mut self, number: i32) {
        todo!()
    }

    fn find(&self, value: i32) -> bool {
        todo!()
    }
}

fn main() {
    let mut two_sum = TwoSum::new();
    two_sum.add(1);
    two_sum.add(3);
    two_sum.add(5);
    println!("{}", two_sum.find(4)); // true
    println!("{}", two_sum.find(7)); // false
}
