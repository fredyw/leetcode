// https://leetcode.com/problems/flatten-2d-vector/description/
struct Vector2D {}

impl Vector2D {
    fn new(vec: Vec<Vec<i32>>) -> Self {
        Self {}
    }

    fn next(&self) -> i32 {
        todo!()
    }

    fn has_next(&self) -> bool {
        todo!()
    }
}

fn main() {
    let v = Vector2D::new(vec![vec![1, 2], vec![3], vec![4]]);
    println!("{}", v.next()); // 1
    println!("{}", v.next()); // 2
    println!("{}", v.next()); // 3
    println!("{}", v.has_next()); // True
    println!("{}", v.has_next()); // True
    println!("{}", v.next()); // 4
    println!("{}", v.has_next()); // False
}
