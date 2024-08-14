// https://leetcode.com/problems/design-hit-counter/
struct HitCounter {}

impl HitCounter {
    fn new() -> Self {
        HitCounter {}
    }

    fn hit(&self, timestamp: i32) {
        todo!()
    }

    fn get_hits(&self, timestamp: i32) -> i32 {
        todo!()
    }
}

fn main() {
    let hit_counter = HitCounter::new();
    hit_counter.hit(1);
    hit_counter.hit(2);
    hit_counter.hit(3);
    println!("{}", hit_counter.get_hits(4)); // 3
    hit_counter.hit(300);
    println!("{}", hit_counter.get_hits(300)); // 4
    println!("{}", hit_counter.get_hits(301)); // 3
}
