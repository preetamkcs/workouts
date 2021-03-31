package dsalgo.plotasciichart;

public class PlotClean {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,2,3,1,2,3,1,2};
        plotSlashChart(arr);
    }

    private static void plotSlashChart(int[] arr) {

        int max_x = 0;
        int max_y;

        int prev_d = 0;
        int max_delta = prev_d;
        int min_delta = prev_d;
        boolean flip = true;

        for (int ele : arr) {
            max_x += ele;
            flip = !flip;
            if (flip) {
                ele *= -1;
            }
            int diff = prev_d + ele;
            max_delta = Math.max(max_delta, diff);
            min_delta = Math.min(min_delta, diff);
            prev_d = diff;
        }
        int cursor_x = -1, cursor_y = 0;
        if (max_delta <= 0) {
            max_y = Math.abs(min_delta);
            cursor_y = max_y;
        } else if (min_delta >= 0) {
            max_y = max_delta;
        } else {
            cursor_y = Math.abs(min_delta);
            max_y = max_delta + cursor_y;
        }

        String[][] buffer = new String[max_y][max_x];
        writeBuffer(arr, cursor_x, cursor_y, buffer);
        printBuffer(buffer);
    }

    private static void writeBuffer(int[] arr, int cursor_x, int cursor_y, String[][] buffer) {
        boolean flip = false;
        for (int streak : arr) {
            for (int i = 0; i < streak; i++) {
                if (flip) {
                    buffer[cursor_y][++cursor_x] = "\\";
                } else {
                    buffer[cursor_y][++cursor_x] = "/";
                }
                if (i != streak - 1) {
                    if (flip) {
                        cursor_y--;
                    } else {
                        cursor_y++;
                    }
                }
            }
            flip = !flip;
        }
    }

    private static void printBuffer(String[][] buffer) {
        for (int i = buffer.length - 1; i >= 0; i--) {
            for (int j = 0; j < buffer[0].length; j++) {
                if (buffer[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(buffer[i][j]);
                }
            }
            System.out.println();
        }
    }
}
