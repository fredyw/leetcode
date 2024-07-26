use std::collections::HashMap;

// https://leetcode.com/problems/design-sql/description/
struct SQL {
    tables: HashMap<String, HashMap<i32, Vec<String>>>,
    ids: HashMap<String, i32>,
}

impl SQL {
    fn new(names: Vec<String>, columns: Vec<i32>) -> Self {
        let mut tables: HashMap<String, HashMap<i32, Vec<String>>> = HashMap::new();
        for name in names {
            tables.insert(name, HashMap::new());
        }
        SQL {
            tables,
            ids: HashMap::new(),
        }
    }

    fn insert_row(&mut self, name: String, row: Vec<String>) {
        let id = self.ids.entry(name.clone()).or_insert(1);
        self.tables.get_mut(&name).unwrap().insert(*id, row);
        *id += 1;
    }

    fn delete_row(&mut self, name: String, row_id: i32) {
        self.tables.get_mut(&name).unwrap().remove(&row_id);
    }

    fn select_cell(&self, name: String, row_id: i32, column_id: i32) -> String {
        self.tables
            .get(&name)
            .unwrap_or(&HashMap::new())
            .get(&row_id)
            .unwrap_or(&Vec::new())
            .get(column_id as usize - 1)
            .unwrap_or(&String::new())
            .clone()
    }
}

fn main() {
    let mut sql = SQL::new(
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
