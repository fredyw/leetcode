use std::collections::{BTreeMap, BTreeSet};

// https://leetcode.com/problems/tweet-counts-per-frequency/
struct TweetCounts {}

impl TweetCounts {
    fn new() -> Self {
        TweetCounts {}
    }

    fn record_tweet(&mut self, tweet_name: String, time: i32) {
        todo!()
    }

    fn get_tweet_counts_per_frequency(
        &self,
        freq: String,
        tweet_name: String,
        start_time: i32,
        end_time: i32,
    ) -> Vec<i32> {
        match tweet_name.as_str() {
            "minute" => (),
            "hour" => (),
            _ => (),
        };
        todo!()
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
