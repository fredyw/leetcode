// https://leetcode.com/problems/latest-time-you-can-obtain-after-replacing-characters/description/
pub fn find_latest_time(s: String) -> String {
    let mut answer = vec!['0', '0', ':', '0', '0'];
    let chars: Vec<char> = s.chars().collect();
    if chars[0] == '?' {
        if chars[1] == '?' || chars[1] <= '1' {
            answer[0] = '1';
        } else {
            answer[0] = '0';
        }
    } else {
        answer[0] = chars[0];
    }

    if chars[1] == '?' {
        if answer[0] == '0' {
            answer[1] = '9';
        } else {
            answer[1] = '1';
        }
    } else {
        answer[1] = chars[1];
    }

    if chars[3] == '?' {
        answer[3] = '5';
    } else {
        answer[3] = chars[3];
    }

    if chars[4] == '?' {
        answer[4] = '9';
    } else {
        answer[4] = chars[4];
    }
    answer.into_iter().collect()
}

fn main() {
    println!("{}", find_latest_time("1?:?4".to_string())); // "11:54"
    println!("{}", find_latest_time("0?:5?".to_string())); // "09:59"
    println!("{}", find_latest_time("??:??".to_string())); // "11:59"
    println!("{}", find_latest_time("01:34".to_string())); // "01:34"
    println!("{}", find_latest_time("?2:??".to_string())); // "02:59"
}
