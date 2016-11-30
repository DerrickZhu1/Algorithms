interval


interval [startTime, stoptime)   ----integral  time stamps. 
给这样的一串区间 I1, I2......In  
找出 一个 time stamp  出现在interval的次数最多。
startTime <= t< stopTime 代表这个数在区间里面出现过。

example：  [1,3),  [2, 7),   [4,  8),   [5, 9)
5和6各出现了三次， 所以答案返回5，6。

class MaxOverpal {}
    public List<Integer> findMaxOverLapTime (Interval[] intervals) {
        List<Integer> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result;
        }
        List<Point> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.time == p2.time) {
                    return p1.isStart ? 1 : 0;
                }
                return p1.time - p2.time;
            }
        });

        int max = 0;
        int number = 0;
        int start = 0;
        int end = 0;
        for (Point point : points) {
            if (point.isStart) {
                number++;
                if (number > max) {
                    max = number;
                    start = point.time;
                    end = point.time;
                }
            }
            else {
                if (number == max) {
                    end = point.time;
                }
                number--;
            }
        }
        for (int i = start; i < end; i++) {
            result.add(i);
        }
        return result;
    }

    private class Point {
        public int time;
        public boolean isStart;
        public Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
}


class Point {
    int time;
    int flag;

    Point(int t, int s){
      this.time = t;
      this.flag = s;
    }
    public static Comparator<Point> PointComparator  = new Comparator<Point>(){
      public int compare(Point p1, Point p2){
      	// p2 在前
        if(p1.time == p2.time) return p1.flag - p2.flag;
        else return p1.time - p2.time;
      }
    };
}

如果time相同时，end在start前
  
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
  public int countOfAirplanes(List<Interval> airplanes) { 
    List<Point> list = new ArrayList<>(airplanes.size()*2);
    for(Interval i : airplanes){
      list.add(new Point(i.start, 1));
      list.add(new Point(i.end, 0));
    }

    Collections.sort(list, Point.PointComparator);
    int count = 0, ans = 0;

    for(Point p : list){
      if (p.flag == 1) count++;
      else count--;
      ans = Math.max(ans, count);
    }

    return ans;
  }
    
}


timePoints.add(new Point(flight.start, 1));
timePoints.add(new Point(flight.end, -1));

// Sort the flight time intervals
        Collection.sort(timePoints, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.time == b.time) {
                    return a.delta - b.delta;
                } else {
                    return a.time - b.time;
                }
            }
        });

        int max = 0;
        int sum = 0;

        // Go through the time points
        for (Point p : timePoints) {
            sum += p.delta;
            max = Math.max(sum, max);
        }

















