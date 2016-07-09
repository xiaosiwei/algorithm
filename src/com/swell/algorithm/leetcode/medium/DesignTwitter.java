package com.swell.algorithm.leetcode.medium;

import java.util.*;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/design-twitter/
 */
public class DesignTwitter {
    private Map relation = new HashMap<Integer,Set<Integer>>();
    private Map entry = new HashMap<Integer, List<Message>>();
    private int total;

    /**
     * Actuall Twitter(), for compile you know.
     */
    public DesignTwitter() {
        relation.clear();
        entry.clear();
        total = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        total ++;
        List list = (List) entry.get(userId);
        if (list == null) {
            list = new ArrayList();
        }

        Message message = new Message();
        message.setOrder(total);
        message.setValue(tweetId);
        list.add(message);

        entry.put(userId, list);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> set = (HashSet<Integer>) relation.get(userId);

        if (set == null) {
            set = new HashSet<Integer>();
        }
        if (!set.contains(userId)) {
            set.add(userId);
        }

        ArrayList<Message> messages = new ArrayList<Message>();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            List tmpSet = (List) entry.get(it.next());
            if (tmpSet != null) {
                messages.addAll(tmpSet);
            }
        }

        Collections.sort(messages);
        int limit = 0;
        if (messages.size() > 10) {
            limit = 10;
        } else {
            limit = messages.size();
        }

        List result = new ArrayList();
        for (int i = 0;i < limit;i++) {
            result.add(messages.get(i).getValue());
        }

        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = (HashSet<Integer>) relation.get(followerId);
        if (set == null) {
            set = new HashSet<Integer>();
        }
        set.add(followeeId);
        relation.put(followerId, set);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> set = (HashSet<Integer>) relation.get(followerId);
        if (set == null) {
            set = new HashSet<Integer>();
        }
        if (set.contains(followeeId)) {
            set.remove(followeeId);
        }
    }

    private static class MyComp implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;

            return -Integer.compare(i1, i2);
        }
    }

    private static class Message implements Comparable{
        private int order;
        private int value;

        @Override
        public int compareTo(Object o) {
            Message message = (Message) o;
            return Integer.compare(message.order, order);
        }


        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
