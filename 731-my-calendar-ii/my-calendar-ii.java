class MyCalendarTwo {
    private List<int[]> calendar;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            int overlapStart = Math.max(start, overlap[0]);
            int overlapEnd = Math.min(end, overlap[1]);
            if (overlapStart < overlapEnd) {
                return false; // Triple booking detected
            }
        }

        for (int[] event : calendar) {
            int eventStart = Math.max(start, event[0]);
            int eventEnd = Math.min(end, event[1]);
            if (eventStart < eventEnd) {
                overlaps.add(new int[] { eventStart, eventEnd });
            }
        }

        calendar.add(new int[] { start, end });
        return true;
    }
}

