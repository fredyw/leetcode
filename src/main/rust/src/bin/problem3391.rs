// https://leetcode.com/problems/design-a-3d-binary-matrix-with-efficient-layer-tracking/description/
struct Matrix3D {}

impl Matrix3D {
    fn new(n: i32) -> Self {
        todo!()
    }

    fn set_cell(&self, x: i32, y: i32, z: i32) {
        todo!()
    }

    fn unset_cell(&self, x: i32, y: i32, z: i32) {
        todo!()
    }

    fn largest_matrix(&self) -> i32 {
        todo!()
    }
}

fn main() {
    let matrix = Matrix3D::new(4);
    matrix.set_cell(2, 1, 1);
    println!("{}", matrix.largest_matrix()); // 2
    matrix.unset_cell(2, 1, 1);
    println!("{}", matrix.largest_matrix()); // 3

    let matrix = Matrix3D::new(4);
    matrix.set_cell(2, 1, 1);
    println!("{}", matrix.largest_matrix()); // 2
    matrix.unset_cell(2, 1, 1);
    println!("{}", matrix.largest_matrix()); // 3
}
