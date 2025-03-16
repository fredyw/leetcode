// https://leetcode.com/problems/design-spreadsheet/
struct Spreadsheet {}

impl Spreadsheet {
    fn new(rows: i32) -> Self {
        Self {}
    }

    fn set_cell(&mut self, cell: String, value: i32) {
        todo!()
    }

    fn reset_cell(&self, cell: String) {
        todo!()
    }

    fn get_value(&self, formula: String) -> i32 {
        todo!()
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
}
