import java.util.*;
import java.text.*;

public class Q10_2 {
    public static void main(String[] args) {
        final String STR_COMMA = ",";       //区切り文字
        boolean ret;                        //メソッド返却値
        int ageTotal = 0;                   //年齢合計
        int ageAvg = 0;                     //年齢平均
        int salTotal = 0;                   //給与合計
        int salAvg = 0;                     //給与平均
        int count = 0;                      //データ件数（人数）
        String fname;                       //ファイル名
        String buf = null;                  //入力用バッファ

        /* インスタンス生成 */
        DecimalFormat form = new DecimalFormat();   //出力書式
        FileIn fi = new FileIn();                   //ファイル入力
        KeyIn ki = new KeyIn();                     //キーボード入力

        /*
         * ファイル名をキーボード入力し、そのファイル名でファイルオープンを行う処理
         * ファイルオープンが正常に行われるまでループ
         */
        ret = false;
        while (ret != true) {
            fname = ki.readString("入力ファイル名:");   //ファイル名入力
            ret = fi.open(fname);                          //ファイルオープン
        }

        /* 
         * ファイルから複数のレコードを入力し、年齢と給与を切り出して数値に変換
         * 変換した年齢と給与をそれぞれ年齢合計および給与合計に加算
         * 全てのレコードを処理したらループから抜ける
         */
        while (true) {
            buf = fi.readLine();            //1レコード入力
            if(buf == null) break;          //入力終了
            try {
                /*
                 * StringTokenizerクラスを用いてトークンを指定して
                 * カンマごとのデータを切り出す
                 */
                StringTokenizer tkn = new StringTokenizer(buf, STR_COMMA);  //番号
                String dummy = tkn.nextToken();
                ageTotal += Integer.parseInt(tkn.nextToken());              //年齢
                salTotal += Integer.parseInt(tkn.nextToken());              //給与

            /* ファイル内のデータに誤りがあった場合の例外処理 */
            } catch (NoSuchElementException e) {            //カンマ区切りの誤り
                System.out.println("データに誤りがあります:" + buf);
                System.out.println("プログラムを異常終了します:" + e);
                fi.close();
                System.exit(1);
            } catch (NumberFormatException e) {             //数字列の誤り
                System.out.println("データに誤りがあります:" + buf);
                System.out.println("プログラムを異常終了します:" + e);
                fi.close();
                System.exit(1);
            } catch (Exception e) {                         //予期せぬエラー
                System.out.println("予期せぬエラーでプログラムを異常終了します:" + e);
                fi.close();
                System.exit(1);
            }
            count++;                        //カウントアップ
        }
        /* ファイルのクローズ処理 */
        ret = fi.close();                   //ファイルクローズ
        if (ret == false) {
            System.out.println("プログラムを異常終了します");
            System.exit(1);
        }

        /* 平均年齢と平均給与を書式編集して画面に出力 */
        System.out.println(count + "件のデータの入力しました");
        if (count != 0) {
            ageAvg = ageTotal / count;      //平均年齢の算出
            salAvg = salTotal / count;      //平均給与の算出
            System.out.println("平均年齢:" + ageAvg + "歳");
            form.applyPattern("###,###,###円");
            System.out.println("平均給与:" + form.format(salAvg));
        }
    }
}
