// https://leetcode.com/problems/design-a-3d-binary-matrix-with-efficient-layer-tracking/description/
struct Matrix3D {
    matrix: Vec<i32>,
    matrix_3d: Vec<Vec<Vec<i32>>>,
}

impl Matrix3D {
    fn new(n: i32) -> Self {
        Self {
            matrix: vec![0; n as usize],
            matrix_3d: vec![vec![vec![0; n as usize]; n as usize]; n as usize],
        }
    }

    fn set_cell(&mut self, x: i32, y: i32, z: i32) {
        if self.matrix_3d[x as usize][y as usize][z as usize] == 0 {
            self.matrix_3d[x as usize][y as usize][z as usize] = 1;
            self.matrix[x as usize] += 1;
        }
    }

    fn unset_cell(&mut self, x: i32, y: i32, z: i32) {
        if self.matrix_3d[x as usize][y as usize][z as usize] == 1 {
            self.matrix_3d[x as usize][y as usize][z as usize] = 0;
            self.matrix[x as usize] -= 1;
        }
    }

    fn largest_matrix(&self) -> i32 {
        let mut max_count = 0;
        let mut max_index = 0;
        for (i, n) in self.matrix.iter().enumerate() {
            if max_count <= *n {
                max_count = *n;
                max_index = i;
            }
        }
        max_index as i32
    }
}

fn main() {
    let mut matrix = Matrix3D::new(4);
    matrix.set_cell(2, 1, 1);
    println!("{}", matrix.largest_matrix()); // 2
    matrix.unset_cell(2, 1, 1);
    println!("{}", matrix.largest_matrix()); // 3

    let mut matrix = Matrix3D::new(4);
    matrix.set_cell(2, 1, 1);
    println!("{}", matrix.largest_matrix()); // 2
    matrix.unset_cell(2, 1, 1);
    println!("{}", matrix.largest_matrix()); // 3

    let mut matrix = Matrix3D::new(7);
    matrix.unset_cell(6, 1, 1);
    matrix.unset_cell(1, 2, 5);
    matrix.unset_cell(2, 3, 1);
    println!("{}", matrix.largest_matrix()); // 6

    let mut matrix = Matrix3D::new(3);
    matrix.set_cell(0, 0, 0);
    matrix.unset_cell(1, 1, 1);
    matrix.unset_cell(1, 1, 2);
    matrix.unset_cell(1, 0, 1);
    matrix.set_cell(2, 1, 2);
    matrix.unset_cell(0, 2, 1);
    matrix.set_cell(0, 0, 0);
    println!("{}", matrix.largest_matrix()); // 2
    matrix.unset_cell(2, 2, 0);
    println!("{}", matrix.largest_matrix()); // 2
}
