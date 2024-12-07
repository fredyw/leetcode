// https://leetcode.com/problems/design-file-system/description/
struct FileSystem {}

impl FileSystem {
    fn new() -> Self {
        todo!()
    }

    fn create_path(&self, path: String, value: i32) -> bool {
        todo!()
    }

    fn get(&self, path: String) -> i32 {
        todo!()
    }
}

fn main() {
    let fs = FileSystem::new();
    println!("{}", fs.create_path("/a".to_string(), 1)); // true
    println!("{}", fs.get("/a".to_string())); // 1

    let fs = FileSystem::new();
    println!("{}", fs.create_path("/leet".to_string(), 1)); // true
    println!("{}", fs.create_path("/leet/code".to_string(), 2)); // true
    println!("{}", fs.get("/leet/code".to_string())); // 2
    println!("{}", fs.create_path("/c/d".to_string(), 1)); // false
    println!("{}", fs.get("/c".to_string())); // -1
}
