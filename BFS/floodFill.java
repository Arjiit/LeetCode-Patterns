class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        Queue<Point> q = new LinkedList<>();
        Point newPoint = new Point(sr, sc);
        int prevColor = image[sr][sc];
        if (prevColor != newColor) {
            q.add(newPoint);
        }
        while(!q.isEmpty()) {
            int s = q.size();
            for (int i=0; i<s; i++) {
                Point poll = q.poll();
                image[poll.x][poll.y] = newColor;
                for (int[] d: dir) {
                    Point new_point = new Point(d[0] + poll.x, d[1] + poll.y);
                    if (new_point.x >= 0 && new_point.x < image.length && new_point.y >= 0 && new_point.y < image[0].length && image[new_point.x][new_point.y] == prevColor) {
                        image[new_point.x][new_point.y] = 2;
                        q.add(new_point);
                    }
                }
            }
        }
        
        return image;
    }
}