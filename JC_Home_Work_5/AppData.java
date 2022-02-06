import java.io.*;

public class AppData {
    private String[] header;
    private int[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void read(File file) {
        int size = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                size++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        header = new String[3];
        data = new int[size-1][];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            header = bufferedReader.readLine().split(";");

            String line;
            int tmp = 0;

            while ((line = bufferedReader.readLine()) != null) {
                String[] dataInString = line.split(";");
                int a = Integer.parseInt(dataInString[0]);
                int b = Integer.parseInt(dataInString[1]);
                int c = Integer.parseInt(dataInString[2]);
                data[tmp] = new int[]{a, b, c};
                tmp++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(header[0] + ";" + header[1] + ";" + header[2] + "\n");

            for (int[] arr : data) {
                bufferedWriter.write(arr[0] + ";" + arr[1] + ";" + arr[2] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
