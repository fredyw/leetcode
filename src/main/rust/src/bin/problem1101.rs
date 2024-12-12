use std::collections::HashMap;

// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/
pub fn earliest_acq(mut logs: Vec<Vec<i32>>, n: i32) -> i32 {
    struct UnionFind {
        // Child to parent
        v: HashMap<char, char>,
    }

    impl UnionFind {
        fn new() -> UnionFind {
            UnionFind { v: HashMap::new() }
        }

        fn union(&mut self, a: char, b: char) {
            if self.v.get(&a).is_none() {
                self.v.insert(a, a);
            }
            if self.v.get(&b).is_none() {
                self.v.insert(b, b);
            }
            let root_a = self.find(a).unwrap();
            let root_b = self.find(b).unwrap();
            if root_a > root_b {
                self.v.insert(root_a, root_b);
            } else if root_a < root_b {
                self.v.insert(root_b, root_a);
            }
        }

        fn find(&self, a: char) -> Option<char> {
            let mut child = a;
            while let Some(parent) = self.v.get(&child) {
                if *parent == child {
                    return Some(*parent);
                }
                child = *parent;
            }
            None
        }
    }

    logs.sort_by(|a, b| a[0].cmp(&b[0]));
    0
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
}
