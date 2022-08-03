use std::collections::{BTreeMap, BTreeSet, HashMap};

// https://leetcode.com/problems/tweet-counts-per-frequency/
struct TweetCounts {
    map: HashMap<String, BTreeMap<i32, i32>>,
}

impl TweetCounts {
    fn new() -> Self {
        TweetCounts {
            map: HashMap::new(),
        }
    }

    fn record_tweet(&mut self, tweet_name: String, time: i32) {
        match self.map.get_mut(&tweet_name) {
            Some(m) => match m.get_mut(&time) {
                Some(m) => {
                    *m += 1;
                }
                None => {
                    m.insert(time, 1);
                }
            },
            None => {
                let mut m: BTreeMap<i32, i32> = BTreeMap::new();
                m.insert(time, 1);
                self.map.insert(tweet_name, m);
            }
        }
    }

    fn get_tweet_counts_per_frequency(
        &self,
        freq: String,
        tweet_name: String,
        start_time: i32,
        end_time: i32,
    ) -> Vec<i32> {
        match tweet_name.as_str() {
            "minute" => {
                let mut time = start_time;
                while time < end_time {
                    time += 60;
                }
            }
            "hour" => (),
            _ => (),
        };
        vec![]
    }
}

fn main() {
    let mut tweet_counts = TweetCounts::new();
    tweet_counts.record_tweet("tweet3".to_string(), 0);
    tweet_counts.record_tweet("tweet3".to_string(), 60);
    tweet_counts.record_tweet("tweet3".to_string(), 60);
    tweet_counts.record_tweet("tweet3".to_string(), 10);
    tweet_counts.record_tweet("tweet3".to_string(), 10);
    tweet_counts.get_tweet_counts_per_frequency("minute".to_string(), "tweet3".to_string(), 0, 59); // [3]
    tweet_counts.get_tweet_counts_per_frequency("minute".to_string(), "tweet3".to_string(), 0, 60); // [3,2]
    tweet_counts.record_tweet("tweet3".to_string(), 120);
    tweet_counts.get_tweet_counts_per_frequency("hour".to_string(), "tweet3".to_string(), 0, 210);
    // [6]
}
