// https://leetcode.com/problems/design-spreadsheet/
struct Spreadsheet {
    grid: Vec<Vec<i32>>,
}

impl Spreadsheet {
    fn new(rows: i32) -> Self {
        Self {
            grid: vec![vec![0; 26]; rows as usize],
        }
    }

    fn set_cell(&mut self, cell: String, value: i32) {
        let (row, col) = self.to_row_col(&cell);
        self.grid[row][col] = value;
    }

    fn reset_cell(&mut self, cell: String) {
        let (row, col) = self.to_row_col(&cell);
        self.grid[row][col] = 0;
    }

    fn get_value(&self, formula: String) -> i32 {
        let split = &formula[1..].split("+").collect::<Vec<&str>>();
        let mut sum = 0;
        if let Ok(n) = split[0].parse::<i32>() {
            sum += n;
        } else {
            let (row, col) = self.to_row_col(split[0]);
            sum += self.grid[row][col];
        }
        if let Ok(n) = split[1].parse::<i32>() {
            sum += n;
        } else {
            let (row, col) = self.to_row_col(split[1]);
            sum += self.grid[row][col];
        }
        sum
    }

    fn to_row_col(&self, cell: &str) -> (usize, usize) {
        let row = *(&cell[1..].parse::<usize>().unwrap()) - 1;
        let col = *(&cell[0..1].chars().next().unwrap()) as usize - 'A' as usize;
        (row, col)
    }
}

fn main() {
    let mut spreadsheet = Spreadsheet::new(3);
    println!("{}", spreadsheet.get_value("=5+7".to_string())); // 12
    spreadsheet.set_cell("A1".to_string(), 10);
    println!("{}", spreadsheet.get_value("=A1+6".to_string())); // 16
    spreadsheet.set_cell("B2".to_string(), 15);
    println!("{}", spreadsheet.get_value("=A1+B2".to_string())); // 25
    spreadsheet.reset_cell("A1".to_string());
    println!("{}", spreadsheet.get_value("=A1+B2".to_string())); // 15

    let spreadsheet = Spreadsheet::new(458);
    println!("{}", spreadsheet.get_value("=O126+10272".to_string())); // 12

    let mut spreadsheet = Spreadsheet::new(24);
    spreadsheet.set_cell("B24".to_string(), 66688);
    spreadsheet.reset_cell("O15".to_string());
}
