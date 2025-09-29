package greedy;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double x1 = points[i][0];
                    double y1 = points[i][1];
                    double x2 = points[j][0];
                    double y2 = points[j][1];
                    double x3 = points[k][0];
                    double y3 = points[k][1];

                    double shoelaceArea = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y1 - y3) + x3 * (y1 - y2));
                    area = Math.max(area, shoelaceArea);
                }
            }
        }
        return area;
    }
}
