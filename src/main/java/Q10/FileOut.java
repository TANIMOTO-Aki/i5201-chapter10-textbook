import java.io.*;

public class FileOut {
    BufferedWriter bw = null;           //BufferedWriterクラス
    /* ファイルのオープンを行うメソッド */
    public boolean open(String fname) {
        boolean sts = true;
        try {
            bw = new BufferedWriter(new FileWriter(fname));
        } catch (IOException e) {
            System.out.println("ファイル名に誤りがあります\n" + e);
            sts = false;
        }
        return sts;
    }

    /* ファイルへのデータ書き込みを行うメソッド */
    public boolean writeln(String str) {
        boolean sts = true;
        try {
            bw.write(str);              //１行分のデータをファイル出力
            bw.newLine();               //行区切り文字を出力
        } catch (IOException e) {
            System.out.println("書き込みエラー\n" + e);
            sts = false;
        }
        return sts;
    }

    /* ファイルのクローズを行うメソッド */
    public boolean close(){
        boolean sts = true;
        try {
            bw.close();                 //ファイルのクローズ
        } catch(IOException e) {
            System.out.println("ファイルのクローズエラー\n" + e);
            sts = false;
        }
        return sts;
    }
}
