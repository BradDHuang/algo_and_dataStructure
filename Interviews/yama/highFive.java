package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
public class Record {
    public int id, score;
    public Record(int id, int score){
        this.id = id;
        this.score = score;
    }
}
*/

public class Main {

    public static Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (Record rec : results) {
            if (!map.containsKey(rec.id)){
                map.put(rec.id, new PriorityQueue<>());
            }
            PriorityQueue<Integer> queue = map.get(rec.id);
            if (queue.size() < 5) {
                queue.offer(rec.score);
            } else {
                if (queue.peek() < rec.score){
                    queue.poll();
                    queue.offer(rec.score);
                }
            }
        }

        for(int id : map.keySet()) {
            PriorityQueue<Integer> q = map.get(id);
            double avg = 0;
            for(int score : q) avg += score;
            avg /=  5;
            res.put(id, avg);
        }

        return res;
    }

    public static void main(String[] args) {
        Record[] res = new Record[]{new Record(1,96),new Record(1,91),
                new Record(1,89),new Record(1,91),new Record(1,91),
                new Record(1,96),new Record(2,90),new Record(2,0),
                new Record(2,0),new Record(2,0),new Record(2,0)};

        System.out.print(highFive(res));
    }

}



