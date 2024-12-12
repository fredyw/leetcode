use std::collections::HashMap;

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

        fn union(&mut self, a: i32, b: i32) -> bool {
            if self.map.get(&a).is_none() {
                self.map.insert(a, a);
            }
            if self.map.get(&b).is_none() {
                self.map.insert(b, b);
            }
            let root_a = self.find(a).unwrap();
            let root_b = self.find(b).unwrap();
            if root_a > root_b {
                self.map.insert(root_a, root_b);
                true
            } else if root_a < root_b {
                self.map.insert(root_b, root_a);
                true
            } else {
                false
            }
        }

        fn find(&self, a: i32) -> Option<i32> {
            let mut child = a;
            while let Some(parent) = self.map.get(&child) {
                if *parent == child {
                    return Some(*parent);
                }
                child = *parent;
            }
            None
        }
    }

    logs.sort_by(|a, b| a[0].cmp(&b[0]));
    let mut uf = UnionFind::new();
    let mut count = n;
    for log in logs {
        let timestamp = log[0];
        let friend_a = log[1];
        let friend_b = log[2];
        if uf.union(friend_a, friend_b) {
            count -= 1;
        }
        if count == 1 {
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
