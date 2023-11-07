package src;

import java.util.HashMap;
// An underground railway system is keeping track of customer travel times between different stations. They are using t
// his data to calculate the average time it takes to travel from one station to another.

public class UndergroundRailwaySystemSolved {
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
    public UndergroundRailwaySystemSolved(){
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
      int total = t - startTime; // endtime - starttime
      if(stationMap.containsKey(getHash(startStation, stationName))){
        AveragePair ap = stationMap.get(getHash(startStation, stationName)); 
        int count = ap.count+1;
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
