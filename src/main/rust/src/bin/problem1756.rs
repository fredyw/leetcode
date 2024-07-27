// https://leetcode.com/problems/design-most-recently-used-queue/description/
struct MRUQueue {
    queue: Vec<i32>,
}

impl MRUQueue {
    fn new(n: i32) -> Self {
        let queue: Vec<i32> = (1..=n).collect();
        MRUQueue { queue }
    }

    fn fetch(&mut self, k: i32) -> i32 {
        let size = self.queue.len();
        let n = self.queue[k as usize - 1];
        if size > 1 {
            for i in (k as usize - 1)..=size - 2 {
                self.queue[i] = self.queue[i + 1];
            }
        }
        self.queue[size - 1] = n;
        n
    }
}

fn main() {
    let mut queue = MRUQueue::new(8);
    println!("{}", queue.fetch(3)); // 3
    println!("{}", queue.fetch(5)); // 6
    println!("{}", queue.fetch(2)); // 2
    println!("{}", queue.fetch(8)); // 2
    println!("{}", queue.fetch(1)); // 2

    let mut queue = MRUQueue::new(1);
    println!("{}", queue.fetch(1)); // 1
}
