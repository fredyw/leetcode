// https://leetcode.com/problems/decode-the-message/
pub fn decode_message(key: String, message: String) -> String {
    todo!()
}

fn main() {
    println!(
        "{}",
        decode_message(
            String::from("the quick brown fox jumps over the lazy dog"),
            String::from("vkbs bs t suepuv")
        )
    ); // "this is a secret"
    println!(
        "{}",
        decode_message(
            String::from("eljuxhpwnyrdgtqkviszcfmabo"),
            String::from("zwx hnfx lqantp mnoeius ycgk vcnjrdb")
        )
    ); // "the five boxing wizards jump quickly"
}
