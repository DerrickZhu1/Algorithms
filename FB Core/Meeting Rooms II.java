Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
         if (intervals == null || intervals.length == 0)
            return 0;
        
         // Sort the intervals by start time
         Arrays.sort(intervals, new Comparator<Interval>() {
             public int compare(Interval a, Interval b) { return a.start - b.start; }
         });
    
         // Use a min heap to track the minimum end time of merged intervals
         PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
              public int compare(Interval a, Interval b) { return a.end - b.end; }
         });
    
         // start with the first meeting, put it to a meeting room
         heap.offer(intervals[0]);
    
         for (int i = 1; i < intervals.length; i++) {
             // get the meeting room that finishes earliest
             Interval interval = heap.poll();
        
             // intervals[i].start >= interval.end
             if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after 
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
             } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
             }
        
             // don't forget to put the meeting room back  要放进去
             heap.offer(interval);
         }
    
         return heap.size();
    }
}


排序好starttime和endtime,遇到starttime +1，遇到endtime-1，同时记录当前starttime，endtime的区间。保持最大的那个count然后返回它的区间不就好了？




