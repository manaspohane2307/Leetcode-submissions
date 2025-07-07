class Solution {
    public int maxEvents(int[][] events) {
        //sort on basis of end day
        Arrays.sort(events, (a,b) -> Integer.compare(a[1],b[1]));
        //create set of all possible days
        TreeSet<Integer> availableDays = new TreeSet<>();
        int lastDay=0;
        for(int[] event : events){
            lastDay = Math.max(lastDay, event[1]);
        }
        //till lastDay add all days in Treeset
        for(int i=0;i<=lastDay;i++){
            availableDays.add(i);
        }

        //for each event find earliest available day in its range
        int count=0;
        for(int[] event : events){
            int start = event[0];
            int end = event[1];
            Integer attendDay = availableDays.ceiling(start);//earliest day >= start
            if(attendDay != null && attendDay<=end){
                availableDays.remove(attendDay);
                count++;
            }
        }
        return count;
    }
}