public class Q10_1 {
    public static void main(String[] args) {
        final String STR_COMMA = ",";               //区切り文字
        boolean ret;                                //メソッドの返却値
        int age;                                    //年齢
        int salary;                                 //給与
        int count = 0;                              //入力件数カウンタ
        String fname;                               //ファイル名
        String buf;                                 //入力バッファ

        /* インスタンス生成 */
        FileOut fo = new FileOut();                 //ファイル出力
        KeyIn ki = new KeyIn();                     //キーボード入力

        /*
         * ファイル名をキーボードに入力し、そのファイル名でファイルオープンを行う
         * ファイルオープンが正常に行われるまでループする
         */
        ret = false;
        while (ret != true) {
            fname = ki.readString("出力ファイル名:");   //ファイル名入力
            ret = fo.open(fname);                          //ファイルオープン
        }

        /* 複数の年齢を給与の組をキーボード入力する処理 */
        while(true) {
            age = ki.readInt((count + 1) + "人目の年齢:");      //年齢入力
            if (age == 999) break;
            salary = ki.readInt((count + 1) + "人目の給与:");   //給与入力

            /* 自動採番した番号と入力文字列（年齢、給与）をファイルへ出力する */
            buf = Integer.toString(count + 1) + STR_COMMA + 
                  Integer.toString(age) + STR_COMMA + 
                  Integer.toString(salary);
            ret = fo.writeln(buf);                          //1レコード出力
            if (ret == false) {                             //エラー判定
                fo.close();
                System.out.println("プログラムを異常終了します");
                System.exit(1);
            }
            count++;                                        //カウントアップ
        }

        /* ファイルのクローズ処理 */
        ret = fo.close();                                   //ファイルクローズ
        if (ret == false) {
            System.out.println("プログラムを異常終了します");
            System.exit(1);
        }
        System.out.print(count + "件のデータをファイルに出力しました");
    }    
}
