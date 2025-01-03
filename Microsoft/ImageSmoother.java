public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;

        int mat[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = smoother(img, i, j);
            }
        }
        return mat;
    }

    public int smoother(int img[][], int x, int y) {
        int sum = 0;
        int cells = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;

                if (nx < 0 || nx >= img.length || ny < 0 || ny >= img[0].length)
                    continue;
                cells++;
                sum += img[nx][ny];
            }
        }

        return sum / cells;
    }
}
