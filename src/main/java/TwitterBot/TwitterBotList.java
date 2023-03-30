package TwitterBot;

import java.util.ArrayList;
import java.util.List;

public class TwitterBotList {

static List<String> botList = new ArrayList<String>();

      public static List<String> messageList() throws InterruptedException {

        //If you try to tweet the same thing, Twitter will recognize you as a bot.
        String a = "something";
        String b = "something else";
        String c = "something entirely different";
        String d = "something completely different";
        String e = "something vastly different";
        String f = "something completely new";
        botList.add(a);
        botList.add(b);
        botList.add(c);
        botList.add(d);
        botList.add(e);
        botList.add(f);
        return botList;
    }
}
