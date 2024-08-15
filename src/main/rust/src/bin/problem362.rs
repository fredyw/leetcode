use std::collections::{HashMap, VecDeque};

// https://leetcode.com/problems/design-hit-counter/
struct HitCounter {
    deque: VecDeque<i32>,
    map: HashMap<i32, i32>,
    count: i32,
}

impl HitCounter {
    fn new() -> Self {
        HitCounter {
            deque: VecDeque::new(),
            map: HashMap::new(),
            count: 0,
        }
    }

    fn hit(&mut self, timestamp: i32) {
        self.count += 1;
        *self.map.entry(timestamp).or_insert(0) += 1;
        self.deque.push_back(timestamp);
    }

    fn get_hits(&mut self, timestamp: i32) -> i32 {
        self.deque.push_back(timestamp);
        if timestamp - 300 >= 0 {
            while let Some(n) = self.deque.front() {
                if *n > timestamp - 300 {
                    break;
                }
                self.count -= self.map.get(n).unwrap_or(&0);
                self.map.remove(n);
                self.deque.pop_front();
            }
        }
        self.count
    }
}

fn main() {
    let mut hit_counter = HitCounter::new();
    hit_counter.hit(1);
    hit_counter.hit(1);
    hit_counter.hit(2);
    hit_counter.hit(3);
    println!("{}", hit_counter.get_hits(4)); // 4
    hit_counter.hit(300);
    println!("{}", hit_counter.get_hits(300)); // 5
    println!("{}", hit_counter.get_hits(310)); // 1
    hit_counter.hit(320);
    println!("{}", hit_counter.get_hits(369)); // 2
    println!("{}", hit_counter.get_hits(1000)); // 0
}
