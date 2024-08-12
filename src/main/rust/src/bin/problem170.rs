use std::collections::HashMap;

// https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
struct TwoSum {
    map: HashMap<i32, i32>,
}

impl TwoSum {
    fn new() -> Self {
        TwoSum {
            map: HashMap::new(),
        }
    }

    fn add(&mut self, number: i32) {
        *self.map.entry(number).or_insert(0) += 1;
    }

    fn find(&self, value: i32) -> bool {
        for n in self.map.keys() {
            if let Some(count) = self.map.get(&(value - n)) {
                if (*n == value - n && *count > 1) || *n != value - n {
                    return true;
                }
            }
        }
        false
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
