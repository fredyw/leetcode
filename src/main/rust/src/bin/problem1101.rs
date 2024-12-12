use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/
pub fn earliest_acq(mut logs: Vec<Vec<i32>>, n: i32) -> i32 {
    struct UnionFind {
        // Child to parent
        map: HashMap<i32, i32>,
    }

    impl UnionFind {
        fn new() -> UnionFind {
            UnionFind {
                map: HashMap::new(),
            }
        }

        fn union(&mut self, a: i32, b: i32) {
            if self.map.get(&a).is_none() {
                self.map.insert(a, a);
            }
            if self.map.get(&b).is_none() {
                self.map.insert(b, b);
            }
            let root_a = *self.map.get(&a).unwrap();
            let root_b = *self.map.get(&b).unwrap();
            if root_a != root_b {
                for (_, v) in self.map.iter_mut() {
                    if *v == root_b {
                        *v = root_a;
                    }
                }
            }
        }

        fn map(&self) -> &HashMap<i32, i32> {
            &self.map
        }
    }

    logs.sort_by(|a, b| a[0].cmp(&b[0]));
    let mut uf = UnionFind::new();
    for log in logs {
        let timestamp = log[0];
        let friend_a = log[1];
        let friend_b = log[2];
        uf.union(friend_a, friend_b);
        let mut set: HashSet<i32> = HashSet::new();
        for (_, v) in uf.map().iter() {
            set.insert(*v);
        }
        if uf.map().len() as i32 == n && set.len() == 1 {
            return timestamp;
        }
    }
    -1
}

fn main() {
    println!(
        "{}",
        earliest_acq(
            vec![
                vec![20190101, 0, 1],
                vec![20190104, 3, 4],
                vec![20190107, 2, 3],
                vec![20190211, 1, 5],
                vec![20190224, 2, 4],
                vec![20190301, 0, 3],
                vec![20190312, 1, 2],
                vec![20190322, 4, 5]
            ],
            6
        )
    ); // 20190301
    println!(
        "{}",
        earliest_acq(
            vec![
                vec![0, 2, 0],
                vec![1, 0, 1],
                vec![3, 0, 3],
                vec![4, 1, 2],
                vec![7, 3, 1]
            ],
            4
        )
    ); // 3
    println!(
        "{}",
        earliest_acq(
            vec![
                vec![20190101, 0, 1],
                vec![20190104, 3, 4],
                vec![20190107, 2, 3],
                vec![20190211, 1, 5],
                vec![20190224, 2, 4],
                vec![20190301, 0, 5],
            ],
            6
        )
    ); // -1
}
