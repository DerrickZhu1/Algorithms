public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>(){
       @Override
       public int compare(Interval inter1, Interval inter2) {
           return inter1.start - inter2.start;
       }
    });
    for (int i = 0; i < intervals.length - 1; i++) {
        if (intervals[i].end > intervals[i + 1].start) {
            return false;
        }
    }
    return true;
}


