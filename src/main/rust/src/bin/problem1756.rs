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
        self.queue.swap(size - 1, n as usize);
        println!("queue: {:?}", self.queue);
        n
    }
}

fn main() {
    let mut queue = MRUQueue::new(8);
    println!("{}", queue.fetch(3)); // 3
    println!("{}", queue.fetch(5)); // 6
    println!("{}", queue.fetch(2)); // 2
    println!("{}", queue.fetch(8)); // 2
}
