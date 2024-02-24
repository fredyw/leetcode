struct DataStream {}

impl DataStream {
    fn new(value: i32, k: i32) -> Self {
        todo!()
    }

    fn consec(&self, num: i32) -> bool {
        todo!()
    }
}

fn main() {
    let data_stream = DataStream::new(4, 3);
    println!("{}", data_stream.consec(4)); // false
    println!("{}", data_stream.consec(4)); // false
    println!("{}", data_stream.consec(4)); // true
    println!("{}", data_stream.consec(3)); // false
}
