package com.wakuei.fakedcard;

public class AppConnection {

    public  static int TimeOut = 1000 * 10;

    public static String[] PopularUrl = {   //熱門文章
            "https://www.dcard.tw/_api/posts?popular=true",  //0 全部
            "https://www.dcard.tw/_api/forums/pokemon/posts?popular=true",  //1 靈異
            "https://www.dcard.tw/_api/forums/bg/posts?popular=true",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/girl/posts?popular=true",  //3 新生季
            "https://www.dcard.tw/_api/forums/makeup/posts?popular=true",  //1 靈異
            "https://www.dcard.tw/_api/forums/funny/posts?popular=true",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/boy/posts?popular=true",  //3 新生季
            "https://www.dcard.tw/_api/forums/horoscopes/posts?popular=true",  //1 靈異
            "https://www.dcard.tw/_api/forums/food/posts?popular=true",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/mood/posts?popular=true",  //3 新生季
            "https://www.dcard.tw/_api/forums/pet/posts?popular=true",  //1 靈異
            "https://www.dcard.tw/_api/forums/trending/posts?popular=true",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/talk/posts?popular=true",  //3 新生季
            "https://www.dcard.tw/_api/forums/movie/posts?popular=true",  //1 靈異
            "https://www.dcard.tw/_api/forums/job/posts?popular=true",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/travel/posts?popular=true",  //3 新生季
            "https://www.dcard.tw/_api/forums/sex/posts?popular=true",  //3 新生季

    };
    public static String[] AllNewUrl = {   //最新文章
            "https://www.dcard.tw/_api/posts?popular=false",  //0 全部
            "https://www.dcard.tw/_api/forums/pokemon/posts?popular=false",  //1 靈異
            "https://www.dcard.tw/_api/forums/bg/posts?popular=false",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/girl/posts?popular=false",  //3 新生季
            "https://www.dcard.tw/_api/forums/makeup/posts?popular=false",  //1 靈異
            "https://www.dcard.tw/_api/forums/funny/posts?popular=false",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/boy/posts?popular=false",  //3 新生季
            "https://www.dcard.tw/_api/forums/horoscopes/posts?popular=false",  //1 靈異
            "https://www.dcard.tw/_api/forums/food/posts?popular=false",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/mood/posts?popular=false",  //3 新生季
            "https://www.dcard.tw/_api/forums/pet/posts?popular=false",  //1 靈異
            "https://www.dcard.tw/_api/forums/trending/posts?popular=false",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/talk/posts?popular=false",  //3 新生季
            "https://www.dcard.tw/_api/forums/movie/posts?popular=false",  //1 靈異
            "https://www.dcard.tw/_api/forums/job/posts?popular=false",  //2 寶可夢
            "https://www.dcard.tw/_api/forums/travel/posts?popular=false",  //3 新生季
            "https://www.dcard.tw/_api/forums/sex/posts?popular=false",  //3 新生季
    };

}
