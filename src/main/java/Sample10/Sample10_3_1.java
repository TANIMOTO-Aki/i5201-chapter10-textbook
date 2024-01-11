import java.io.*;

public class Sample10_3_1 {
    public static void main(String[] args) {
        String buf;                             //入力バッファ
        int i = 0;                              //カウンタ
        boolean flag = true;                    //終了フラグ
                                                                //①
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            /* ファイルから文字列を入力する処理 */
            while (flag) {                                      //②
                buf = br.readLine();                            //③
                if (buf != null) {
                    i++;
                    System.out.println(i + ": " + buf);         //④
                } else {
                    flag = false;                               //⑤
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("ファイル名を指定してください");   //⑥
            System.exit(1);
        } catch (IOException e) {                               //⑦
            System.out.print("ファイルアクセスエラー" + e);
        }
    }
}
/* 
 * 【プログラムの説明】
 * ①    コマンドライン引数で指定されたファイル名を指定して、ファイルをオープンする
 *      tryブロックを抜けるときにファイルを自動的にクローズする
 * ②    ファイルから１行分のデータを読み込み、画面に出力する処理を繰り返すためのループ
 *      ファイルの終わりに達した場合、⑤でflagにfalseがセットされ、ループから抜ける
 * ③    ファイルから１行分のデータを読み込む
 * ④    ③でファイルから入力したデータを画面に出力する
 * ⑥    コマンドライン引数でファイル名を指定しなかった場合に、配列の要素以外の参照で発生する例外を
 *      catchするためにArrayIndexOutOfBoundsException例外を指定する
 *      この例外は、配列を参照している①で発生する可能性がある。この例外をcatchした場合は、
 *      エラーメッセージを画面に出力し、プログラムを強制的に異常終了させている
 * ⑦    ファイル入出力にかかわる例外をcatchするために、IOException例外を指定する
 *      この例外は、ファイル入出力に絡む①、③の処理で発生する可能性がある。
 *      この例外をcatchした場合、エラーメッセージを画面に出力する
 */