class Solution {
/*
    prison state repeating after a certian number of iterations.
*/
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashSet<String> set = new HashSet<>();
        int times = 0;
        boolean flag = false;
        for (int i=0; i<N; i++) {
            int[] nextArray = nextDays(cells);
            String arrString = Arrays.toString(nextArray);
            if (!set.contains(arrString)) {
                set.add(arrString);
                times++;
            } else {
                flag = true;
                break;
            }
            cells = nextArray;
        }
        if (flag) {
            N = N%times;
            for (int i=0; i<N; i++) {
                cells = nextDays(cells);
            }
        }
        return cells;
    }
    
    public int[] nextDays(int[] cells) {
        int[] res = new int[cells.length];
        for(int i=1; i<cells.length -1; i++){
            if (cells[i-1] == cells[i+1]) {
               res[i] = 1; 
            }
        }
        return res;
    }
}