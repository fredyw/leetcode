use std::collections::{BTreeMap, HashMap};
use std::ops::Bound::{Excluded, Included};

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
        fn f(
            map: &HashMap<String, BTreeMap<i32, i32>>,
            tweet_name: &String,
            start_time: i32,
            end_time: i32,
            chunk: i32,
            v: &mut Vec<i32>,
        ) {
            let mut time = start_time;
            while time <= end_time {
                match map.get(tweet_name) {
                    Some(m) => {
                        let count: i32 = m
                            .range((Included(time), Excluded((end_time + 1).min(time + chunk))))
                            .into_iter()
                            .map(|a| a.1)
                            .sum();
                        v.push(count);
                    }
                    None => v.push(0),
                }
                time += chunk;
            }
        }

        let mut v = vec![];
        match freq.as_str() {
            "minute" => f(&self.map, &tweet_name, start_time, end_time, 60, &mut v),
            "hour" => f(&self.map, &tweet_name, start_time, end_time, 3600, &mut v),
            _ => f(&self.map, &tweet_name, start_time, end_time, 86400, &mut v),
        };
        v
    }
}

fn main() {
    let mut tweet_counts = TweetCounts::new();
    tweet_counts.record_tweet("tweet3".to_string(), 0);
    tweet_counts.record_tweet("tweet3".to_string(), 60);
    tweet_counts.record_tweet("tweet3".to_string(), 60);
    tweet_counts.record_tweet("tweet3".to_string(), 10);
    tweet_counts.record_tweet("tweet3".to_string(), 10);
    println!(
        "{:?}",
        tweet_counts.get_tweet_counts_per_frequency(
            "minute".to_string(),
            "tweet3".to_string(),
            0,
            59
        )
    ); // [3]
    println!(
        "{:?}",
        tweet_counts.get_tweet_counts_per_frequency(
            "minute".to_string(),
            "tweet3".to_string(),
            0,
            60
        )
    ); // [3,2]
    tweet_counts.record_tweet("tweet3".to_string(), 120);
    println!(
        "{:?}",
        tweet_counts.get_tweet_counts_per_frequency(
            "hour".to_string(),
            "tweet3".to_string(),
            0,
            210
        )
    ); // [6]
    println!(
        "{:?}",
        tweet_counts.get_tweet_counts_per_frequency(
            "hour".to_string(),
            "tweet4".to_string(),
            0,
            210
        )
    ); // [0]
    println!(
        "{:?}",
        tweet_counts.get_tweet_counts_per_frequency(
            "hour".to_string(),
            "tweet3".to_string(),
            70,
            80
        )
    ); // [0]
}
