import java.io.*;
import java.nio.charset.Charset;

public class KeyIn {
    String buf = null;                          //①　入力バッファの初期化
    BufferedReader br =                         //②　キーボード入力の準備
            new BufferedReader(new InputStreamReader(System.in,
                    Charset.forName(System.getProperty("native.encoding"))));
    
    /* 文字列を入力するメソッド */
    public String readString() {
        try {
            buf = br.readLine();                //③　キーボード入力
        } catch (IOException e ) {              //キーボード入力致命的エラー
            System.out.println(e);              //エラー情報の表示
            System.exit(1);              //プログラムの異常終了
        }
        return buf;                             //④　文字列を返却
    }

    /* 入力プロンプトを表示して文字列を入力するメソッド */
    public String readString(String msg) {
        System.out.print(msg + ">");            //⑤　プロンプト表示
        return readString();                    //⑥　キーボード入力
    }

    /* 整数値を入力するメソッド */
    public int readInt() {
        int inputIntValue;
        while (true) {
        buf = readString();
            try {
                inputIntValue = Integer.parseInt(buf);  //数値に変換
                break;                                  //ループ終了
            } catch (NumberFormatException e) {
                System.out.println("整数値を入力してください:" + buf);
                System.out.print("再入力>");
            }
        }
        return inputIntValue;                           //変換した値の返却
    }

    /* 入力プロンプトを表示して整数値を入力するメソッド */
    public int readInt(String msg) {
        System.out.print(msg + ">");                    //プロンプトの表示
        return readInt();                               //readInt()の呼び出し
    }
}
/*
 * 【プログラムの説明】
 * ①　キーボード入力した文字列をセットする変数bufを定義し、null値で初期化を行う
 * ②　BufferedReaderクラスのインスタンスを生成し、brに代入してキーボード入力の準備を行う
 * ③　brのreadLineメソッドを用いてキーボード入力を行う
 * ④　③でキーボード入力した文字列をプロンプト表示している
 * ⑤　引数で受け取った文字列をプロンプト表示している
 * ⑥　引数なしのreadStringメソッドを呼び出し、
 * 　　その戻り値として受け取った文字列を呼び出し側のプログラムに返す
 */