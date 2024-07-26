// https://leetcode.com/problems/design-sql/description/
struct SQL {}

impl SQL {
    fn new(names: Vec<String>, columns: Vec<i32>) -> Self {
        SQL {}
    }

    fn insert_row(&self, name: String, row: Vec<String>) {
        todo!()
    }

    fn delete_row(&self, name: String, row_id: i32) {
        todo!()
    }

    fn select_cell(&self, name: String, row_id: i32, column_id: i32) -> String {
        todo!()
    }
}

fn main() {
    let sql = SQL::new(
        vec!["one".to_string(), "two".to_string(), "three".to_string()],
        vec![2, 3, 1],
    );
    sql.insert_row(
        "two".to_string(),
        vec![
            "first".to_string(),
            "second".to_string(),
            "third".to_string(),
        ],
    );
    println!("{}", sql.select_cell("two".to_string(), 1, 3)); // "third"
    sql.insert_row(
        "two".to_string(),
        vec![
            "fourth".to_string(),
            "fifth".to_string(),
            "sixth".to_string(),
        ],
    );
    sql.delete_row("two".to_string(), 1);
    println!("{}", sql.select_cell("two".to_string(), 2, 2)); // "fifth"
}
