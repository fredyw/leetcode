// https://leetcode.com/problems/encode-and-decode-strings/
struct Codec {}

impl Codec {
    fn new() -> Self {
        Self {}
    }

    fn encode(&self, strs: Vec<String>) -> String {
        todo!()
    }

    fn decode(&self, s: String) -> Vec<String> {
        todo!()
    }
}

fn main() {
    let codec = Codec::new();
    println!(
        "{:?}",
        codec.decode(codec.encode(vec!["Hello".to_string(), "World".to_string()]))
    ); // ["Hello","World"]
    println!("{:?}", codec.decode(codec.encode(vec!["".to_string()]))); // [""]
}
