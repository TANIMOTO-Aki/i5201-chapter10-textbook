import java.util.*;         //StringTokenizerクラスのパッケージ

public class Exam10 {
    public static void main(String[] args) {
        try {
            /* StringTokenizer作成 区切り文字 "," */
            StringTokenizer tkn = new StringTokenizer("Monday,October 27,2020", ",");
            System.out.println(tkn.nextToken());    //"Monday"を出力
            System.out.println(tkn.nextToken());    //"October 27"を出力
            System.out.println(tkn.nextToken());    //"2020"を出力
            System.out.println(tkn.nextToken());    //例外発生（トークンなし）
        } catch (NoSuchElementException e) {        //例外ハンドラ
            System.out.println("トークンが残っていません");
        } finally {
            System.out.print("---- プログラム終了 ----");
        }
    }
}
