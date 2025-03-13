import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileService {

    private Scanner scanner = null;
    private String line = "";
    private int index = 0;

    /**
     * Used to open a file
     * @param fullFileName
     * @return
     * @throws FileNotFoundException
     */
    public boolean openFile(String fullFileName) throws FileNotFoundException {
        boolean returnVal = true;

        File f = new File(fullFileName);
        scanner = new Scanner(f);

        return returnVal;
    }

    /**
     * used to read columns, the file must be opened before invocation
     * @return
     */
    public String readColums(String delimeter)
    {
        String returnVal = "File not opened";
        if(scanner != null) {
            scanner.useDelimiter(delimeter);
            if (scanner.hasNext()) {
                returnVal = scanner.next();
            }
            else {
                returnVal = "eof";
                scanner.close();
            }
        }
        return returnVal;
    }

    /**
     * Reads the fixed sized columns
     * @param size
     * @return
     */
    public String readFixedColums(int size)
    {
        String returnVal = "File not opened";
        if(scanner != null) {

            if (line.equals("") && scanner.hasNextLine()) {
                line = scanner.nextLine();
                returnVal = line.substring(index*size,(index+1)*size);
                index++;
            }
            else if(!line.equals("") ) {
                returnVal = line.substring(index * size, (index + 1) * size);
                index++;
                if (line.length() <= (index) * size)
                {
                    line = "";
                    index=0;
                    returnVal += "\n";
                }
            }
            else {
                returnVal = "eof";
                scanner.close();
            }
        }
        return returnVal;
    }





}
