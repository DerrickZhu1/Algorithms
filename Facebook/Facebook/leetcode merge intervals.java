44. leetcode merge intervals

// Sort the intervals by the start time
// Traverse from the head to end
// If the current interval's end time is bigger or euqals to the next start time
// Then merger, new end time is the max(cur.end, next.end)
// else put this interval into result

public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, new Comparator<Interval>() {
       @Override
       public int compare(Interval inter1, Interval inter2) {
           return inter1.start - inter2.start;
       }
    });

    List<Interval> result = new ArrayList<>();
    
    if (intervals.size() == 0) {
        return result;
    }

    Interval cur = new Interval(intervals.get(0).start, intervals.get(0).end);
    for (int i = 1; i < intervals.size(); i++) {
        Interval interval = intervals.get(i);
        // interval.start <= cur.end
        if (interval.start <= cur.end) {
            cur.end = Math.max(cur.end, interval.end);
        }
        else {
            result.add(new Interval(cur.start, cur.end));
            cur.start = interval.start;
            cur.end = interval.end;
        }
    }
    // result.add(cur);
    result.add(cur);
    return result;
}