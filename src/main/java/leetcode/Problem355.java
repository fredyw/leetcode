package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/design-twitter/
 */
public class Problem355 {
    private static class Twitter {
        // key -> follower
        // value -> set of followees
        private final Map<Integer, Set<Integer>> users = new HashMap<>();
        // key -> user ID
        // value -> set of tweet IDs
        private final Map<Integer, List<Tweet>> posts = new HashMap<>();
        private long timestamp;

        private static class Tweet implements Comparable<Tweet> {
            private final int tweetId;
            private final long timestamp;

            public Tweet(int tweetId, long timestamp) {
                this.tweetId = tweetId;
                this.timestamp = timestamp;
            }

            @Override
            public int compareTo(Tweet o) {
                return Long.compare(o.timestamp, timestamp);
            }
        }

        /** Initialize your data structure here. */
        public Twitter() {
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            init(userId);
            posts.get(userId).add(new Tweet(tweetId, timestamp++));
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user followed or by the user herself.
         * Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> newsFeed = new ArrayList<>();
            if (!users.containsKey(userId)) {
                return newsFeed;
            }
            PriorityQueue<Tweet> tweets = new PriorityQueue<>();
            tweets.addAll(posts.get(userId));
            Set<Integer> followees = users.get(userId);
            for (int followee : followees) {
                if (posts.containsKey(followee)) {
                    tweets.addAll(posts.get(followee));
                }
            }
            for (int i = 0; i < 10; i++) {
                if (tweets.isEmpty()) {
                    break;
                }
                newsFeed.add(tweets.poll().tweetId);
            }
            return newsFeed;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            init(followerId);
            users.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            init(followerId);
            users.get(followerId).remove(followeeId);
        }

        private void init(int userId) {
            if (!users.containsKey(userId)) {
                users.put(userId, new HashSet<>());
            }
            if (!posts.containsKey(userId)) {
                posts.put(userId, new ArrayList<>());
            }
        }
    }
}
