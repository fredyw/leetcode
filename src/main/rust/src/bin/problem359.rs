use std::collections::HashMap;

struct Logger {
    map: HashMap<String, i32>,
}

impl Logger {
    fn new() -> Self {
        Logger {
            map: HashMap::new(),
        }
    }

    fn should_print_message(&mut self, timestamp: i32, message: String) -> bool {
        match self.map.get_mut(&message) {
            None => {
                self.map.insert(message, timestamp + 10);
                true
            }
            Some(ts) => {
                if timestamp >= *ts {
                    *ts = timestamp + 10;
                    true
                } else {
                    false
                }
            }
        }
    }
}

fn main() {
    let mut logger = Logger::new();
    println!("{}", logger.should_print_message(1, "foo".to_string())); // true
    println!("{}", logger.should_print_message(2, "bar".to_string())); // true
    println!("{}", logger.should_print_message(3, "foo".to_string())); // false
    println!("{}", logger.should_print_message(8, "bar".to_string())); // false
    println!("{}", logger.should_print_message(10, "foo".to_string())); // false
    println!("{}", logger.should_print_message(11, "foo".to_string())); // true

    let mut logger = Logger::new();
    println!("{}", logger.should_print_message(0, "A1".to_string())); // true
    println!("{}", logger.should_print_message(3, "A4".to_string())); // true
    println!("{}", logger.should_print_message(6, "A0".to_string())); // true
    println!("{}", logger.should_print_message(9, "A3".to_string())); // true
    println!("{}", logger.should_print_message(12, "A3".to_string())); // false
    println!("{}", logger.should_print_message(15, "A4".to_string())); // true
    println!("{}", logger.should_print_message(18, "A3".to_string())); // false
    println!("{}", logger.should_print_message(21, "A2".to_string())); // true
    println!("{}", logger.should_print_message(24, "A1".to_string())); // true
    println!("{}", logger.should_print_message(27, "A2".to_string())); // false
    println!("{}", logger.should_print_message(30, "A0".to_string())); // true
    println!("{}", logger.should_print_message(33, "A0".to_string())); // false
}
