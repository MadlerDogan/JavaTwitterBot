package TwitterBot;

import java.util.ArrayList;
import java.util.List;

public class TwitterBotList {

static List<String> botList = new ArrayList<String>();

      public static List<String> listDepo () throws InterruptedException {

          //birebir aynı tweeti atamaya çalışırsanız Twetter bot olduğunuzu anlıyor.
        String a = "birşeyler";
        String b = "Başka birşeyler";
        String c = "Daha başka birşeyler";
        String d = "Daha da başka birşeyler";
        String e = "Çok daha başka birşeyler";
        String f = " Bambaşka birşeyler";
        botList.add(a);
        botList.add(b);
        botList.add(c);
        botList.add(d);
        botList.add(e);
        botList.add(f);


        return botList;
    }
}
