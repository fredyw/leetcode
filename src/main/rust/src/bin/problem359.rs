struct Logger {}

impl Logger {
    fn new() -> Self {
        todo!()
    }

    fn should_print_message(&self, timestamp: i32, message: String) -> bool {
        todo!()
    }
}

fn main() {
    let logger = Logger::new();
    println!("{}", logger.should_print_message(1, "foo".to_string())); // true
    println!("{}", logger.should_print_message(2, "bar".to_string())); // true
    println!("{}", logger.should_print_message(3, "foo".to_string())); // false
    println!("{}", logger.should_print_message(8, "bar".to_string())); // false
    println!("{}", logger.should_print_message(10, "foo".to_string())); // false
    println!("{}", logger.should_print_message(11, "foo".to_string())); // true
}
