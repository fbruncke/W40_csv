import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //new Main().writeFixedSizeFile();
        new Main().fileServiceReadFixedSizeFile();
        //new TestScanner().readWithScanner();
        //new Main().readChar();
        //new Main().TestWriteCsv();
        //new Main().fileServiceReadCSVFile();
        //new Main().TestReadCsvReading();
        //new Main().TestAppendCsv();


    }

    private  void fileServiceReadCSVFile() throws FileNotFoundException {
        FileService fs = new FileService();
        //fs.openFile("c:\\tmp\\dataSemi.csv");
        fs.openFile("dataSemi.csv");

        String lastVal = "";
        while(!lastVal.equals("eof")) {
            lastVal = fs.readColums(";");
            System.out.print(lastVal + " - ");
        }
    }

    private void TestWriteCsv() throws FileNotFoundException {
        Customer[] customers = {new Customer("Homelander", "Prime Road" ,1),
                                new Customer("Snowman", "Snow road" ,20),
                                new Customer("Mario", "Nintendo road", 300)};

        PrintWriter pw = new PrintWriter("dataSemi.csv");
        String delimiter = ";";
        StringBuilder sb = new StringBuilder();

        for(Customer c: customers)
        {
            sb.setLength(0);    //reset
            sb.append(c.name());
            sb.append(delimiter);
            sb.append(c.address());
            sb.append(delimiter);
            sb.append(c.houseNo());
            pw.println(sb.toString());
        }
        pw.close();

    }

    private void TestAppendCsv() throws IOException {

        FileOutputStream fos = new FileOutputStream("dataSemi.csv", true);
        PrintWriter pw = new PrintWriter(fos);
        pw.println("Hi HI");
        pw.close();
        fos.close();
    }


    private void TestReadCsvReading() throws FileNotFoundException {
        //File f = new File("c:\\tmp\\dataSemi.csv");
        File f = new File("dataSemi.csv");
        Scanner scanner = new Scanner(f);

        while (scanner.hasNextLine())
        {
            String[] data = scanner.nextLine().split(";");

            System.out.printf("\nCustomer: %s lives on %s and house no %s",data[0],data[1], data[2]);
        }
        scanner.close();
    }

    //region fixed columns
    private  void fileServiceReadFixedSizeFile() throws FileNotFoundException {

        FileService fs = new FileService();
        //fs.openFile("c:\\tmp\\data.csv");
        fs.openFile("datafixed.txt");

        String lastVal = "";
        while(!(lastVal = fs.readFixedColums(10)).equals("eof")) {
            System.out.print(lastVal );
        }
    }

    public void writeFixedSizeFile() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("datafixed.txt");
            pw.println("Cola      200       calories  ");
            pw.println("Milk      100       calories  ");
            pw.println("Beer      150       calories  ");
            pw.println("Wine      400       calories  ");

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            pw.close();
        }
    }
//endregion

    //region read chars
    private void readChar() throws FileNotFoundException {
        File iFile = new File("datafixed.txt");
        Scanner in = new Scanner(iFile);
        in.useDelimiter("");
        while( in.hasNext() )
        {

            //System.out.print( in.next().charAt(0) );
            Character aChar = in.next().charAt(0);
            if( Character.isDigit(aChar))
            {
                //int x = Character.getNumericValue(aChar);
                System.out.print(aChar);
            }

        }
        System.out.println("");
        in.close();
    }
    //endregion
}
