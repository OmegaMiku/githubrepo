package hw4;

public class TriangleArea {
    public static double calculateArea(double A, double B, double C) throws Exception {
        if (A <= 0 || B <= 0 || C <= 0) {
            throw new Exception("Некорректный треугольник!");
        } else if (A + B < C || A + C < B || C + B < A) {
            throw new Exception("Вырожденный треугольник!");
        }

        double halfP = (A + B + C) / 2;
        double area = (halfP * (halfP - A) * (halfP - B) * (halfP - C));
        return Math.sqrt(area);

    }
}
