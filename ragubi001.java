import java.util.Scanner;

class ragubi001{
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);

        //選手の人数Nとイベント数Qを読み込む

        int N =sc.nextInt();
        int Q =sc.nextInt();

        //１番～N番の選手の状態を管理する配列（インデックス０は使わないためN+１個用意）
        //0:なし,1:イエロー１枚,2:退場処分（イエロー2枚またはレッド1枚）
        int[]cards =new int[N+1];

        //出力をバッファー（一次保存)するためのStringBuilder
        StringBuilder sb = new StringBuilder();

        for (int q = 0; q < Q; q++) {
            int type = sc.nextInt(); // イベントの種類 (1, 2, 3)
            int i = sc.nextInt();    // 選手の番号 (1 〜 N)

            if (type == 1) {
                // イエローカードは +1
                cards[i] += 1;
            } else if (type == 2) {
                // レッドカードは一発退場なので +2
                cards[i] += 2;
            } else if (type == 3) {
                // 2以上なら退場処分
                if (cards[i] >= 2) {
                    sb.append("Yes\n");
                } else {
                    sb.append("No\n");
                }
            }
        }

        // 全イベントを読み込んだ後にまとめて出力
        System.out.print(sb.toString());
    }
}


