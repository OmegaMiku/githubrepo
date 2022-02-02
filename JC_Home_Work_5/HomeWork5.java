import java.io.*;

class HomeWork5 {
    public static void main(String[] args) {
        File dataFile = new File("src/data.csv");
        File resultFile = new File("src/result.csv");

        char[] dataArr = new char[100];

        try (BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(dataFile))) {
            int tmp;
            int count = 0;
            while ((tmp = fileInputStream.read()) != -1) {
                dataArr[count] = (char) tmp;
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        for (char c : dataArr) {
            System.out.print(c);
        }

        try (BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(resultFile))) {
            for (char c : dataArr) {
                fileOutputStream.write((byte) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("src/AppData.csv");
        AppData appData = new AppData("Value 1", 100, 300);
        AppData appData1 = new AppData("Value 2", 200, 400);
        AppData appData2 = new AppData("Value 3", 123, 500);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file))) {
            objectOutputStream.writeObject(appData);
            objectOutputStream.writeObject(appData1);
            objectOutputStream.writeObject(appData2);
        } catch (IOException e) {
        }

        AppData readAppData = null;
        AppData readAppData1 = null;
        AppData readAppData2 = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(file))) {
            readAppData = (AppData) objectInputStream.readObject();
            readAppData1 = (AppData) objectInputStream.readObject();
            readAppData2 = (AppData) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class AppData implements Serializable {
    private String header;
    private int data;
    private int data1;

    public AppData(String header, int data, int data1) {
        this.header = header;
        this.data = data;
        this.data1 = data1;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "header='" + header + '\'' +
                ", data=" + data +
                ", data1=" + data1 +
                '}';
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }
}





