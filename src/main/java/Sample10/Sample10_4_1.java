import java.io.*;                                                   //①
import java.util.*;                                                 //②

public class Sample10_4_1 {
    public static void main(String[] args) {
        File f = null;
        /* Fileクラスのインスタンスを生成 */
        try {
            f = new File(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {                //③
            System.out.print("ファイル名を指定してください");
            System.exit(1);
        }

        /* ファイルに関する情報を画面出力 */
        if (f.exists()) {                                           //④
            System.out.println("ファイル名　　　:" + f.getName());   //⑤
                                                                    //⑥
            System.out.println("絶対パス名　　　:" + f.getAbsolutePath());
            System.out.println("パス名　　　　　:" + f.toString());  //⑦
            System.out.println("親ディレクトリ名:" + f.getParent()); //⑧
            System.out.println("ファイルの長さ　:" + f.length());    //⑨
            System.out.println("読み込み可能　　:" + f.canRead());   //⑩
            System.out.println("編集可能　　　　:" + f.canWrite());  //⑪
            System.out.println("隠しファイル　　:" + f.isHidden());  //⑫
            Date d = new Date(f.lastModified());                    //⑬
            System.out.print("最終更新時刻　　:" + d.toString());    //⑭
        } else {
                                                                    //⑮
            System.out.print("指定されたファイルは存在しません:" + args[0]);
        }
    }
}
/* 
 * 【プログラムの説明】
 * ①    java.io.*をインポートする。Fileクラスはjava.ioパッケージに含まれるので必要
 * ②    java.util.*をインポートする。⑬で使用しているDateクラスがjava.utilパッケージに含まれるので必要
 * ③    コマンドライン引数で指定されたファイル名を指定して、Fileクラスのインスタンスを生成し、
 *      変数fに代入する
 * ④    existsメソッドを使って、③で指定したファイルが存在するかどうかを調べる。
 *      ファイルが存在する場合は、⑤～⑭の処理でファイルに関する情報を取得し画面に出力する。
 * ⑥    getAbsolitePathメソッドは、Fileクラスのインスタンス生成時の指定にかかわらず、常に絶対パス名を戻す
 * ⑦    toStringメソッドは、Fileクラスのインスタンス生成時に指定したファイルのパス名をそのまま戻す
 * ⑧    getParentメソッドは、ファイルが格納されているディレクトリ名を戻す。ただし、Fileクラスのインスタンス
 *      生成時に指定したパス名がもとになるので、ファイル名のみを指定した場合はnullが戻される。
 *      また、絶対パス名を指定した場合は格納ディレクトリの絶対パスを戻す
 * ⑨～⑭ 各種ファイル情報を取得し画面に出力する
 * ⑮    指定したファイルが存在しない場合の処理。
 *      ここでは、その旨のメッセージを指定されたファイル名とともに出力している
 */
