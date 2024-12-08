use std::collections::HashMap;

// https://leetcode.com/problems/design-file-system/description/
struct FileSystem {
    map: HashMap<String, i32>,
}

impl FileSystem {
    fn new() -> Self {
        Self {
            map: HashMap::new(),
        }
    }

    fn create_path(&mut self, path: String, value: i32) -> bool {
        if let Some(index) = path.rfind('/') {
            if self.map.contains_key(&path) {
                return false;
            }
            if index > 0 {
                let parent = &path[0..index];
                if !self.map.contains_key(parent) {
                    return false;
                }
            }
            self.map.insert(path, value);
            true
        } else {
            false
        }
    }

    fn get(&self, path: String) -> i32 {
        *self.map.get(&path).unwrap_or(&-1)
    }
}

fn main() {
    let mut fs = FileSystem::new();
    println!("{}", fs.create_path("/a".to_string(), 1)); // true
    println!("{}", fs.get("/a".to_string())); // 1
    println!("{}", fs.create_path("/a/b".to_string(), 2)); // true
    println!("{}", fs.get("/a/b".to_string())); // 2
    println!("{}", fs.create_path("/a/b/c/d".to_string(), 3)); // false
    println!("{}", fs.get("/a/b/c".to_string())); // -1

    let mut fs = FileSystem::new();
    println!("{}", fs.create_path("/leet".to_string(), 1)); // true
    println!("{}", fs.create_path("/leet/code".to_string(), 2)); // true
    println!("{}", fs.get("/leet/code".to_string())); // 2
    println!("{}", fs.create_path("/c/d".to_string(), 1)); // false
    println!("{}", fs.get("/c".to_string())); // -1

    let mut fs = FileSystem::new();
    println!("{}", fs.create_path("/leet".to_string(), 1)); // true
    println!("{}", fs.create_path("/leet/code".to_string(), 2)); // true
    println!("{}", fs.create_path("/leet/code".to_string(), 3)); // false
    println!("{}", fs.get("/leet/code".to_string())); // 2

    let mut fs = FileSystem::new();
    println!("{}", fs.create_path("/a".to_string(), 1)); // true
    println!("{}", fs.create_path("/a".to_string(), 2)); // false
    println!("{}", fs.get("/a".to_string())); // 1
}
