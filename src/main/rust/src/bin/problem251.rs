// https://leetcode.com/problems/flatten-2d-vector/description/
struct Vector2D {
    row: usize,
    col: usize,
    vec: Vec<Vec<i32>>,
}

impl Vector2D {
    fn new(vec: Vec<Vec<i32>>) -> Self {
        Self {
            row: 0,
            col: 0,
            vec,
        }
    }

    fn next(&mut self) -> i32 {
        let val = self.vec[self.row][self.col];
        if self.col + 1 == self.vec[self.row].len() {
            self.row += 1;
            self.col = 0;
        } else {
            self.col += 1;
        }
        val
    }

    fn has_next(&self) -> bool {
        let num_rows = self.vec.len();
        if self.row >= num_rows {
            return false;
        }
        let num_cols = self.vec[self.row].len();
        self.col < num_cols
    }
}

fn main() {
    let mut v = Vector2D::new(vec![vec![1, 2], vec![3], vec![4]]);
    println!("{}", v.next()); // 1
    println!("{}", v.next()); // 2
    println!("{}", v.next()); // 3
    println!("{}", v.has_next()); // true
    println!("{}", v.has_next()); // true
    println!("{}", v.next()); // 4
    println!("{}", v.has_next()); // false
}
