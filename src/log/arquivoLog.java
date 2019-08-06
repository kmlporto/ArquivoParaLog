package log;

import java.io.*;
import java.util.Vector;

public class arquivoLog   {
    static File file;
    static FileReader fileReader;
    static FileWriter fileWriter;
    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    static public void escreverLog(String log) throws IOException {
        try {
            file = new File("log.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            Vector texto = new Vector();
            while(bufferedReader.ready()){
                texto.add(bufferedReader.readLine());
            }
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < texto.size(); i++){
                bufferedWriter.write(texto.get(i).toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.write(log);

            bufferedReader.close();
            bufferedWriter.close();


        } catch (FileNotFoundException e) {
            file.createNewFile();

        }
    }
}
