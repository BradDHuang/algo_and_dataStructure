package com.company;

import java.util.*;
// java 自带！

public class miniTwitter {

    // Definition of Tweet:
     public static class Tweet {
         public int id;
         public int user_id;
         public String text;
         public static Tweet create(int user_id, String tweet_text) {
             // This will create a new tweet object,
             // and auto fill id
             return null;
         }
     }

    public class MiniTwitter {

        // 为了简化问题，不会真的去获取系统时间来给推特排序，
        // 而是使用一个变量order，每发布一条消息，order自增1，
        // 这样我们就知道order大的发布的就晚，

        // 我们新建一个结构体Node，用来给每个tweet绑定一个order
        class Node {
            public int order;
            public Tweet tweet;
            public Node(int o, Tweet t) {
                this.order = o;
                this.tweet = t;
            }
        }

        // 写一个从一个Node数组中返回最后10个Node的函数，
        public List<Node> getLastTen(List<Node> tmp) {
            int last = 10;
            if (tmp.size() < 10) {
                last = tmp.size();
            }
            return tmp.subList(tmp.size() - last, tmp.size());
        }

        // 再写一个从一个Node数组中返回前10个Node的函数，

        // 比如[1, 2, 3] 我们getLastTwo 得到了[2, 3],
        // 再用getFirstTwo 得到[3, 2].

        public List<Node> getFirstTen(List<Node> tmp) {
            int last = 10;
            if (tmp.size() < 10) {
                last = tmp.size();
            }
            return tmp.subList(0, last);
        }

        // 我们还需要2个哈希表，一个用来建立每个用户和其所有好友之间的映射，
        // 另一个用来建立每个用户和其发布的所有推特之间的映射，
        // 另外我们还需要一个变量order来记录发布推特的顺序。
        private Map<Integer, Set<Integer>> friends;

        private Map<Integer, List<Node>> users_tweets;

        private int order;

        public MiniTwitter() {
            // initialize your data structure here.
            this.friends = new HashMap<Integer, Set<Integer>>();

            this.users_tweets = new HashMap<Integer, List<Node>>();

            this.order = 0;
        }

        // 对于postTweet函数，我们首先利用Tweet类提供的create函数建立一个tweet，
        // 然后我们看发布者是否在users_tweets里，如果不在就添加这个用户，
        // 然后将这条推特加到其映射数组中，最后返回tweet。

        public Tweet postTweet(int user_id, String tweet_text) {
            //  Write your code here
            Tweet tweet = Tweet.create(user_id, tweet_text);

            if (!users_tweets.containsKey(user_id)) {
                users_tweets.put(user_id, new ArrayList<Node>());
            }

            order++;

            users_tweets.get(user_id).add(new Node(order, tweet));
            return tweet;
        }

        // 对于getNewsFeed函数，我们先把该用户的推特集中最新10条保存下来，
        // 然后遍历其所有的好友，将其好友的最新10条保存下来，
        // 然后整个按时间先后顺序排序，返回最新10条即可。
        public List<Tweet> getNewsFeed(int user_id) {
            // Write your code here
            List<Node> tmp = new ArrayList<Node>();

            if (users_tweets.containsKey(user_id)) {
                tmp.addAll(getLastTen(users_tweets.get(user_id)));
            }

            if (friends.containsKey(user_id)) {
                for (Integer user : friends.get(user_id)) {
                    if (users_tweets.containsKey(user)) {
                        tmp.addAll(getLastTen(users_tweets.get(user)));
                    }
                }
            }

            Collections.sort(tmp, new SortByOrder());
            List<Tweet> rt = new ArrayList<Tweet>();

            tmp = getFirstTen(tmp);

            for (Node node : tmp) {
                rt.add(node.tweet);
            }
            return rt;
        }

        class SortByOrder implements Comparator {
            public int compare(Object obj1, Object obj2) {
                Node node1 = (Node) obj1;
                Node node2 = (Node) obj2;
                // if (node1.order < node2.order) {
                //     return 1;
                // } else {
                //     return -1;
                // }
                return node2.order - node1.order;
            }
        }

        // 对于getTimeline函数，我们先从该用户的推特集中返回最新的10条推特，
        // 然后按时间先后顺序排序，然后再返回即可。
        public List<Tweet>  getTimeline(int user_id) {
            // Write your code here
            List<Node> tmp = new ArrayList<Node>();
            if (users_tweets.containsKey(user_id)) {
                tmp.addAll(getLastTen(users_tweets.get(user_id)));
            }
            Collections.sort(tmp, new SortByOrder());
            List<Tweet> rt = new ArrayList<Tweet>();
            tmp = getFirstTen(tmp);
            for (Node node : tmp) {
                rt.add(node.tweet);
            }
            return rt;
        }

        public void follow(int from_user_id, int to_user_id) {
            // Write your code here
            if (!friends.containsKey(from_user_id)) {
                friends.put(from_user_id, new HashSet<Integer>());
            }
            friends.get(from_user_id).add(to_user_id);
        }

        public void unfollow(int from_user_id, int to_user_id) {
            // Write your code here
            if (friends.containsKey(from_user_id)) {
                friends.get(from_user_id).remove(to_user_id);
            }
        }
    }

    public static void main(String[] args) {
        // write your code here

        System.out.println();

    }
}