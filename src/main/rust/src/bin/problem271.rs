// https://leetcode.com/problems/encode-and-decode-strings/
struct Codec {}

impl Codec {
    fn new() -> Self {
        Self {}
    }

    fn encode(&self, strs: Vec<String>) -> String {
        // 1,2,3|4,5,6
        strs.into_iter()
            .map(|s| {
                s.as_bytes()
                    .into_iter()
                    .map(|&b| format!("{}", b))
                    .collect::<Vec<String>>()
                    .join(",")
            })
            .collect::<Vec<String>>()
            .join("|")
    }

    fn decode(&self, s: String) -> Vec<String> {
        s.split('|')
            .map(|a| {
                a.split(',')
                    .into_iter()
                    .filter(|b| !b.is_empty())
                    .map(|b| b.parse::<u8>().unwrap() as char)
                    .collect::<String>()
            })
            .collect()
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
