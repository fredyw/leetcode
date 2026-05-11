use itertools::Itertools;
use std::collections::{HashMap, VecDeque};

// https://leetcode.com/problems/first-unique-number/description/
struct FirstUnique {
    deque: VecDeque<i32>,
    map: HashMap<i32, bool>,
}

impl FirstUnique {
    fn new(nums: Vec<i32>) -> Self {
        let mut map: HashMap<i32, bool> = HashMap::with_capacity(nums.len());
        for num in &nums {
            map.entry(*num)
                .and_modify(|is_unique| *is_unique = false)
                .or_insert(true);
        }
        Self {
            deque: VecDeque::from(nums),
            map,
        }
    }

    fn show_first_unique(&mut self) -> i32 {
        while let Some(front) = self.deque.front() {
            if let Some(unique) = self.map.get(front) {
                if *unique {
                    return *front;
                }
            } else {
                self.deque.pop_front();
            }
        }
        -1
    }

    fn add(&mut self, value: i32) {
        if let Some(unique) = self.map.get_mut(&value) {
            *unique = false;
        } else {
            self.map.insert(value, true);
            self.deque.push_back(value);
        }
    }
}

fn main() {
    let mut first_unique = FirstUnique::new(vec![2, 3, 5]);
    println!("{}", first_unique.show_first_unique()); // 2
    first_unique.add(5);
    println!("{}", first_unique.show_first_unique()); // 2
    first_unique.add(2);
    println!("{}", first_unique.show_first_unique()); // 3
    first_unique.add(3);
    println!("{}", first_unique.show_first_unique()); // -1

    // let mut first_unique = FirstUnique::new(vec![7, 7, 7, 7, 7, 7]);
    // println!("{}", first_unique.show_first_unique()); // -1
    // first_unique.add(7);
    // first_unique.add(3);
    // first_unique.add(3);
    // first_unique.add(7);
    // first_unique.add(17);
    // println!("{}", first_unique.show_first_unique()); // 17
    //
    // let mut first_unique = FirstUnique::new(vec![809]);
    // println!("{}", first_unique.show_first_unique()); // 809
    // first_unique.add(809);
    // println!("{}", first_unique.show_first_unique()); // -1
}
