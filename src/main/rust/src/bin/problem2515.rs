// https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/
pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
    if words[start_index as usize] == target {
        return 0;
    }
    let mut found = false;
    let mut forward_count = 1;
    let mut i = (start_index + 1) % words.len() as i32;
    while i != start_index {
        if words[i as usize] == target {
            found = true;
            break;
        }
        i = (i + 1) % words.len() as i32;
        forward_count += 1;
    }
    if !found {
        return -1;
    }
    let mut backward_count = 1;
    let mut i = start_index - 1;
    if i < 0 {
        i = words.len() as i32 - 1;
    }
    while i != start_index {
        if words[i as usize] == target {
            break;
        }
        i -= 1;
        if i < 0 {
            i = words.len() as i32 - 1;
        }
        backward_count += 1;
    }
    forward_count.min(backward_count)
}

fn main() {
    println!(
        "{}",
        closet_target(
            vec![
                "hello".to_string(),
                "i".to_string(),
                "am".to_string(),
                "leetcode".to_string(),
                "hello".to_string()
            ],
            "hello".to_string(),
            1
        )
    ); // 1
    println!(
        "{}",
        closet_target(
            vec!["a".to_string(), "b".to_string(), "leetcode".to_string()],
            "leetcode".to_string(),
            0
        )
    ); // 1
    println!(
        "{}",
        closet_target(
            vec!["i".to_string(), "eat".to_string(), "leetcode".to_string()],
            "ate".to_string(),
            0
        )
    ); // -1
    println!(
        "{}",
        closet_target(
            vec![
                "ibkgecmeyx".to_string(),
                "jsdkekkjsb".to_string(),
                "gdjgdtjtrs".to_string(),
                "jsdkekkjsb".to_string(),
                "jsdkekkjsb".to_string(),
                "jsdkekkjsb".to_string(),
                "gdjgdtjtrs".to_string(),
                "msjlfpawbx".to_string(),
                "pbgjhutcwb".to_string(),
                "gdjgdtjtrs".to_string()
            ],
            "pbgjhutcwb".to_string(),
            0
        )
    ); // 2
    println!(
        "{}",
        closet_target(
            vec![
                "hsdqinnoha".to_string(),
                "mqhskgeqzr".to_string(),
                "zemkwvqrww".to_string(),
                "zemkwvqrww".to_string(),
                "daljcrktje".to_string(),
                "fghofclnwp".to_string(),
                "djwdworyka".to_string(),
                "cxfpybanhd".to_string(),
                "fghofclnwp".to_string(),
                "fghofclnwp".to_string()
            ],
            "zemkwvqrww".to_string(),
            8
        )
    ); // 4
}
