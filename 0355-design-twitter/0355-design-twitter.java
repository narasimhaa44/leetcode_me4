import java.util.*;

class Tweet{

    int tweetId;
    int time;

    Tweet(int tweetId,int time){

        this.tweetId=tweetId;
        this.time=time;
    }
}

class Twitter {

    int timer=0;

    HashMap<Integer,HashSet<Integer>> followMap;

    HashMap<Integer,List<Tweet>> tweetMap;

    public Twitter(){

        followMap=new HashMap<>();

        tweetMap=new HashMap<>();
    }

    public void postTweet(int userId,int tweetId){

        tweetMap.putIfAbsent(userId,new ArrayList<>());

        tweetMap.get(userId).add(new Tweet(tweetId,timer++));

    }

    public List<Integer> getNewsFeed(int userId){

        PriorityQueue<Tweet> maxHeap=
                new PriorityQueue<>((a,b)->b.time-a.time);

        List<Integer> ans=new ArrayList<>();

        followMap.putIfAbsent(userId,new HashSet<>());

        followMap.get(userId).add(userId);

        for(int followee:followMap.get(userId)){

            if(tweetMap.containsKey(followee)){

                for(Tweet t:tweetMap.get(followee)){

                    maxHeap.offer(t);
                }
            }
        }

        int count=0;

        while(!maxHeap.isEmpty() && count<10){

            ans.add(maxHeap.poll().tweetId);

            count++;
        }

        return ans;
    }

    public void follow(int followerId,int followeeId){

        followMap.putIfAbsent(followerId,new HashSet<>());

        followMap.get(followerId).add(followeeId);

    }

    public void unfollow(int followerId,int followeeId){

        if(followMap.containsKey(followerId)){

            followMap.get(followerId).remove(followeeId);
        }
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