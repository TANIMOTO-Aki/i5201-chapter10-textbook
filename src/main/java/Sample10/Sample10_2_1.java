import java.io.*;

public class Sample10_2_1 {
    public static void main(String[] args) {
        String buf;                                     //入力バッファ
        int i = 0;                                      //カウンタ
        boolean flag = true;                            //終了フラグ

        KeyIn ki = new KeyIn();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]))) { //①

            /* 文字列のキーボード入力処理 */
            while (flag) {                              //②
                buf = ki.readString((i + 1) + ":");     //③
                if (buf.length() != 0) {
                    bw.write(buf);                      //④
                    bw.newLine();                       //⑤
                    i++;
                } else {
                    flag = false;                       //⑥
                }
            }
            System.out.print(i + "件のデータを" + args[0] + "に書き込みました");
        } catch (ArrayIndexOutOfBoundsException e) {    //⑦
            System.out.println("ファイル名を指定してください");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("ファイルアクセスエラー:" + e);
        }
    }
}
/*
 * 【プログラムの説明】
 * ①    コマンドライン引数で指定されたファイル名を指定して、ファイルをオープンする
 *      tryブロックを抜け出すときには、ファイルをクローズする(try-with-resoures)
 * ②    キーボードからデータを入力されている間、ファイルへの書き込みを繰り替えすループ
 *      [Enter]キーのみ入力された場合、⑥でflagにfalseがセットされ、ループを抜ける
 * ③    キーボードからのデータ入力を行う
 * ④    ③でキーボード入力した文字列をファイルに書き込む
 * ⑤    行間区切り文字をらファイルに書き込む
 * ⑦    コマンドライン引数でファイル名を指定しなかった場合に、配列の要素以外の参照で発生する例外を
 *      catchするためにArrayIndexOutOfBoundsException例外を指定する
 *      この例外は、配列を参照している①で発生する可能性がある。この例外をcatchした場合は、
 *      エラーメッセージを画面に出力し、プログラムを強制的に異常終了させている
 * ⑧    ファイル入出力にかかわる例外をcatchするために、IOException例外を指定する
 *      この例外は、ファイル入出力に絡む①、④、⑤の処理で発生する可能性がある。
 *      この例外をcatchした場合、エラーメッセージを画面に出力する
 */