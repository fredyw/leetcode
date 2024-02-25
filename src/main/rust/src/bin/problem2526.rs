struct DataStream {
    value: i32,
    k: i32,
    count: i32,
}

impl DataStream {
    fn new(value: i32, k: i32) -> Self {
        DataStream {
            value,
            k,
            count: 0,
        }
    }

    fn consec(&mut self, num: i32) -> bool {
        if self.value != num {
            self.count = 0;
        } else {
            self.count += 1;
        }
        self.count >= self.k
    }
}

fn main() {
    let mut data_stream = DataStream::new(4, 3);
    println!("{}", data_stream.consec(4)); // false
    println!("{}", data_stream.consec(4)); // false
    println!("{}", data_stream.consec(4)); // true
    println!("{}", data_stream.consec(3)); // false

    let mut data_stream  = DataStream::new(1, 2);
    println!("{}", data_stream.consec(1)); // false
    println!("{}", data_stream.consec(2)); // false
    println!("{}", data_stream.consec(1)); // false
    println!("{}", data_stream.consec(1)); // true
    println!("{}", data_stream.consec(1)); // true
}
