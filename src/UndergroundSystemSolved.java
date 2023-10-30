package src;

import java.util.HashMap;

public class UndergroundSystemSolved {
    class Pair{
        String start;
        String end;
        int t;
        Pair(String start, String end, int t){
            this.start = start;
            this.end = end;
            this.t = t;
        }
    }

    class AveragePair{
        int count;
        int totalTime;
        AveragePair(int count, int totalTime){
            this.count = count;
            this.totalTime = totalTime;
        }
    }
    HashMap<Integer, Pair>hm;
    HashMap<Integer, AveragePair>stationMap;
    public UndergroundSystemSolved(){
        hm = new HashMap<>();
        stationMap = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t){
        hm.put(id, new Pair(stationName, "", t));
    }
    public void checkOut(int id, String stationName, int t){
      Pair pair = hm.remove(id);
      String startStation = pair.start;
      int startTime = pair.t;
      int total = t - startTime;
      if(stationMap.containsKey(getHash(startStation, stationName))){
        AveragePair ap = stationMap.get(getHash(startStation, stationName)); 
        int count = ap.count;
        int time = ap.totalTime+total;
        stationMap.put(getHash(startStation, stationName), new AveragePair(count, time));
      }
      else{
        stationMap.put(getHash(startStation, stationName), new AveragePair(1, total));
      }
    }

    public double getAverage(String startStation, String endStation){
        AveragePair ap = stationMap.get(getHash(startStation, endStation));
        int count = ap.count;
        int time = ap.totalTime;
        double answer = (time * 1.0) /(count * 1.0);
        return answer;

    }
    private int getHash(String startStation, String endStation) {
        return (int)(startStation +"#" + endStation).hashCode();
    }
}
