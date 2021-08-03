package src.LEETCODE;

import java.util.*;

public class leet_355 {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }
}

class Twitter {
    private Map<Integer, Set<Integer>> followList = new HashMap<>();
    private LinkedList<Integer> allPostList = new LinkedList<>();
    private Map<Integer, Set<Integer>> postList = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Set<Integer> tmp = postList.getOrDefault(userId, new HashSet<>());
        tmp.add(tweetId);

        postList.put(userId, tmp);
        allPostList.addFirst(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        Set<Integer> tmp = new HashSet<>();
        if(postList.get(userId) != null){
            tmp = new HashSet<>(postList.get(userId));
        }

        Set<Integer> members = new HashSet<>();
        if(followList.get(userId) != null){
            members = followList.get(userId);

            for (Integer member : members) {
                if(postList.get(member) != null){
                    tmp.addAll(postList.get(member));
                }

            }
        }


        for(int i=0; i<allPostList.size(); i++){
            int value = allPostList.get(i);

            if(tmp.contains(value)){
                res.add(value);
            }

            if(res.size() > 9){
                break;
            }
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> tmp = followList.getOrDefault(followerId, new HashSet<>());
        tmp.add(followeeId);

        followList.put(followerId, tmp);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> tmp = followList.getOrDefault(followerId, new HashSet<>());
        tmp.remove(followeeId);

        followList.put(followerId, tmp);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */