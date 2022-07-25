use std::collections::{BTreeSet, HashMap};

// https://leetcode.com/problems/design-a-number-container-system/
struct NumberContainers {
    index_to_number_map: HashMap<i32, i32>,
    number_to_indexes_map: HashMap<i32, BTreeSet<i32>>,
}

impl NumberContainers {
    fn new() -> Self {
        NumberContainers {
            index_to_number_map: HashMap::new(),
            number_to_indexes_map: HashMap::new(),
        }
    }

    fn change(&mut self, index: i32, number: i32) {
        if let Some(old_number) = self.index_to_number_map.get(&index) {
            if let Some(indexes) = self.number_to_indexes_map.get_mut(&old_number) {
                indexes.remove(&index);
            }
        }
        self.index_to_number_map.insert(index, number);
        match self.number_to_indexes_map.get_mut(&number) {
            Some(indexes) => {
                indexes.insert(index);
            }
            None => {
                let mut set: BTreeSet<i32> = BTreeSet::new();
                set.insert(index);
                self.number_to_indexes_map.insert(number, set);
            }
        }
    }

    fn find(&self, number: i32) -> i32 {
        self.number_to_indexes_map
            .get(&number)
            .map_or(-1, |set| *set.iter().next().unwrap_or(&-1))
    }
}

fn main() {
    let mut nc = NumberContainers::new();
    println!("{}", nc.find(10)); // -1
    nc.change(2, 10);
    nc.change(1, 10);
    nc.change(3, 10);
    nc.change(5, 10);
    println!("{}", nc.find(10)); // 1
    nc.change(1, 20);
    println!("{}", nc.find(10)); // 2
    nc.change(2, 20);
    println!("{}", nc.find(10)); // 3
    println!("{}", nc.find(20)); // 1
}
