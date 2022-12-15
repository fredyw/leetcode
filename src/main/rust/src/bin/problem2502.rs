use std::collections::HashMap;

// https://leetcode.com/problems/design-memory-allocator/
struct Allocator {
    memory: Vec<i32>,
    m_id_to_indexes: HashMap<i32, Vec<usize>>,
}

impl Allocator {
    fn new(n: i32) -> Self {
        Allocator {
            memory: vec![0; n as usize],
            m_id_to_indexes: HashMap::new(),
        }
    }

    fn allocate(&mut self, size: i32, m_id: i32) -> i32 {
        let mut index = 0;
        let mut count = 0;
        while index < self.memory.len() {
            if self.memory[index] == 0 {
                count += 1;
                if count == size {
                    break;
                }
            } else {
                count = 0;
            }
            index += 1;
        }
        if index == self.memory.len() {
            return -1;
        }
        for i in index as i32 - size + 1..=index as i32 {
            self.m_id_to_indexes
                .entry(m_id)
                .or_insert(vec![])
                .push(i as usize);
            self.memory[i as usize] = m_id;
        }
        index as i32 - size + 1
    }

    fn free(&mut self, m_id: i32) -> i32 {
        let index = match self.m_id_to_indexes.get(&m_id) {
            None => 0,
            Some(indexes) => {
                for i in indexes.iter() {
                    self.memory[*i] = 0;
                }
                indexes.len() as i32
            }
        };
        self.m_id_to_indexes.remove(&m_id);
        index
    }
}

fn main() {
    let mut allocator = Allocator::new(10);
    println!("{}", allocator.allocate(1, 1)); // 0
    println!("{}", allocator.allocate(1, 2)); // 1
    println!("{}", allocator.allocate(1, 3)); // 2
    println!("{}", allocator.free(2)); // 1
    println!("{}", allocator.allocate(3, 4)); // 3
    println!("{}", allocator.allocate(1, 1)); // 1
    println!("{}", allocator.allocate(1, 1)); // 6
    println!("{}", allocator.free(1)); // 3
    println!("{}", allocator.allocate(10, 2)); // -1
    println!("{}", allocator.free(7)); // 0
}
