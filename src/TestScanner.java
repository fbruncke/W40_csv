import java.util.Scanner;

public class TestScanner {
    public void readWithScanner() {
        String mixedData = "123 who 456 are 789 you true false";
        Scanner lineScanner = new Scanner(mixedData);

        while (lineScanner.hasNext())
        {
            if(lineScanner.hasNextInt())
                System.out.println("int: "+lineScanner.nextInt());

            else if(lineScanner.hasNextBoolean())
                System.out.println("Boolean: "+lineScanner.nextBoolean());

            else if(lineScanner.hasNext())
                System.out.println("string: "+lineScanner.next());

        }

    }
}