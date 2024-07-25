// https://leetcode.com/problems/design-compressed-string-iterator/description/
struct StringIterator {}

impl StringIterator {
    fn new(compressedString: String) -> Self {
        StringIterator {}
    }

    fn next(&self) -> char {
        todo!()
    }

    fn has_next(&self) -> bool {
        todo!()
    }
}

fn main() {
    let iter = StringIterator::new("L1e2t1C1o1d1e1".to_string());
    println!("{}", iter.next()); // "L"
    println!("{}", iter.next()); // "e"
    println!("{}", iter.next()); // "e"
    println!("{}", iter.next()); // "t"
    println!("{}", iter.next()); // "C"
    println!("{}", iter.next()); // "o"
    println!("{}", iter.has_next()); // true
    println!("{}", iter.next()); // "d"
    println!("{}", iter.has_next()); // true
    println!("{}", iter.next()); // "e"
    println!("{}", iter.has_next()); // false
}
