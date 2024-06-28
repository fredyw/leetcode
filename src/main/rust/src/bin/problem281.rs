// https://leetcode.com/problems/zigzag-iterator/description/
struct ZigzagIterator {}

impl ZigzagIterator {
    /** initialize your data structure here. */
    fn new(v1: Vec<i32>, v2: Vec<i32>) -> Self {
        ZigzagIterator {}
    }

    fn next(&mut self) -> i32 {
        todo!()
    }

    fn has_next(&self) -> bool {
        todo!()
    }
}

fn to_vec(mut iterator: ZigzagIterator) -> Vec<i32> {
    let mut v = vec![];
    while (iterator.has_next()) {
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
}
