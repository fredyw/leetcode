// https://leetcode.com/problems/zigzag-iterator/description/
struct ZigzagIterator {
    v1: Vec<i32>,
    v2: Vec<i32>,
    i1: usize,
    i2: usize,
    first: bool,
}

impl ZigzagIterator {
    fn new(v1: Vec<i32>, v2: Vec<i32>) -> Self {
        ZigzagIterator {
            v1,
            v2,
            i1: 0,
            i2: 0,
            first: true,
        }
    }

    fn next(&mut self) -> i32 {
        let val = if self.first && self.i1 < self.v1.len() {
            let v = self.v1[self.i1];
            self.i1 += 1;
            v
        } else {
            let v = self.v2[self.i2];
            self.i2 += 1;
            v
        };
        if self.first && self.i2 < self.v2.len() {
            self.first = false;
        } else if !self.first && self.i1 < self.v1.len() {
            self.first = true;
        }
        val
    }

    fn has_next(&self) -> bool {
        self.i1 < self.v1.len() || self.i2 < self.v2.len()
    }
}

fn to_vec(mut iterator: ZigzagIterator) -> Vec<i32> {
    let mut v = vec![];
    while iterator.has_next() {
        v.push(iterator.next());
    }
    v
}

fn main() {
    let iter = ZigzagIterator::new(vec![1, 2], vec![3, 4, 5, 6]);
    println!("{:?}", to_vec(iter)); // [1,3,2,4,5,6]

    let iter = ZigzagIterator::new(vec![1], vec![]);
    println!("{:?}", to_vec(iter)); // [1]

    let iter = ZigzagIterator::new(vec![], vec![1]);
    println!("{:?}", to_vec(iter)); // [1]

    let iter = ZigzagIterator::new(vec![3, 4, 5, 6], vec![1, 2]);
    println!("{:?}", to_vec(iter)); // [3,1,4,2,5,6]

    let iter = ZigzagIterator::new(vec![], vec![]);
    println!("{:?}", to_vec(iter)); // []
}
