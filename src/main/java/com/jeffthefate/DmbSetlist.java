package com.jeffthefate;

import java.util.ArrayList;
import java.util.HashMap;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import com.jeffthefate.setlist.Setlist;

public class DmbSetlist {
	
	private static final String PROD_KEY = "LG23SHRfn5E5aFld0kc9sdLEG";
	private static final String PROD_SECRET = "EBsmiO5Aj9chSVQGElZ5falYWX02Dqw4GmdgEOekkuDHMlHGOX";
	private static final String PROD_ACCESS_TOKEN = "611044728-ojJ9OszvvtV4ATU36JYZhhdk9BoaDfvbHFzUzqvY";
	private static final String PROD_ACCESS_SECRET = "jrjcTJWSnzUBAaXpYXMEZazVhEHohoXlDktd9a2kM6rE5";
	private static final String PROD_ACCOUNT = "dmbtrivia";
	
	private static final String DEV_KEY = "BXx60ptC4JAMBQLQ965H3g";
	private static final String DEV_SECRET = "0ivTqB1HKqQ6t7HQhIl0tTUNk8uRnv1nhDqyFXBw";
	private static final String DEV_ACCESS_TOKEN = "1265342035-6mYSoxlw8NuZSdWX0AS6cpIu3We2CbCev6rbKUQ";
	private static final String DEV_ACCESS_SECRET = "XqxxE4qLUK3wJ4LHlIbcSP1m6G4spZVmCDdu5RLuU";
	private static final String DEV_ACCOUNT = "dmbtriviatest";
	
	private static final String TRIVIA2_KEY = "eMuFTZYxt3X35zhiOmnOyJuAS";
	private static final String TRIVIA2_SECRET = "0ITfF0A1Ew6wNvJUFKpxVgF6qCdKk8nLPgluSFhsfDnvURp6Xu";
	private static final String TRIVIA2_ACCESS_TOKEN = "2357105641-VsaREbnEYoiyi0pb3s68Ucgsr6E9iGHjQzqtctS";
	private static final String TRIVIA2_ACCESS_SECRET = "MmsrjVpjneQnf3s8FyXfzWK98h6o8dqu5M4xsZEd4S6kv";
	private static final String TRIVIA2_ACCOUNT = "dmbtrivia2";

	private static String CURR_KEY = PROD_KEY;
	private static String CURR_SECRET = PROD_SECRET;
	private static String CURR_ACCESS_TOKEN = PROD_ACCESS_TOKEN;
	private static String CURR_ACCESS_SECRET = PROD_ACCESS_SECRET;
	private static String CURR_ACCOUNT = PROD_ACCOUNT;
	
	private static final String SETLIST_DIR = "/home/SETLISTS/";
    private static final String SETLIST_FILENAME = SETLIST_DIR + "setlist";
    private static final String SETLIST_FILENAME_DEV = SETLIST_DIR +
    		"setlist_dev";
	private static final String LAST_SONG_DIR = "/home/LAST_SONGS/";
    private static final String LAST_SONG_FILENAME = LAST_SONG_DIR +
    		"last_song";
    private static final String LAST_SONG_FILENAME_DEV = LAST_SONG_DIR +
    		"last_song_dev";
    private static final String SETLIST_JPG_FILENAME = "/home/setlist.jpg";
    private static final String ROBOTO_FONT_FILENAME = "/home/roboto.ttf";
    
    private static final int SETLIST_FONT_SIZE = 21;
    private static final int SETLIST_VERTICAL_OFFSET = 70;
    
    private static Setlist setlist;
    
    private static ArrayList<ArrayList<String>> nameList = new ArrayList<ArrayList<String>>(0);
	private static ArrayList<String> symbolList = new ArrayList<String>(0);
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = null;
    	long duration = 0;
    	boolean isDev = false;
		try {
			if (args.length > 0)
				duration = Long.valueOf(args[0]);
			if (args.length > 1)
				isDev = Boolean.valueOf(args[1]);
			if (args.length > 2)
				url = args[2];
		} catch (NumberFormatException e) {}
		if (isDev) {
			CURR_KEY = DEV_KEY;
			CURR_SECRET = DEV_SECRET;
			CURR_ACCESS_TOKEN = DEV_ACCESS_TOKEN;
			CURR_ACCESS_SECRET = DEV_ACCESS_SECRET;
		}
		setupAnswerMap();
		setlist = new Setlist(url, duration, isDev, setupTweet(false),
				setupTweet(true), SETLIST_JPG_FILENAME, ROBOTO_FONT_FILENAME,
				SETLIST_FONT_SIZE, SETLIST_VERTICAL_OFFSET,
				isDev ? SETLIST_FILENAME_DEV : SETLIST_FILENAME,
				isDev ? LAST_SONG_FILENAME_DEV : LAST_SONG_FILENAME,
				SETLIST_DIR, nameList, symbolList, TRIVIA2_ACCOUNT);
		setlist.startSetlist();
	}
	
	private static Configuration setupTweet(boolean isGame) {
    	ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(isGame ? TRIVIA2_KEY : CURR_KEY)
		  .setOAuthConsumerSecret(isGame ? TRIVIA2_SECRET : CURR_SECRET)
		  .setOAuthAccessToken(isGame ? TRIVIA2_ACCESS_TOKEN : CURR_ACCESS_TOKEN)
		  .setOAuthAccessTokenSecret(isGame ? TRIVIA2_ACCESS_SECRET : CURR_ACCESS_SECRET)
		  .setUseSSL(true);
		return cb.build();
    }
	
	private static void setupAnswerMap() {
    	ArrayList<String> tempList = new ArrayList<String>(0);
    	tempList.add("belly belly nice");
    	tempList.add("bbn");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("the riff");
    	tempList.add("riff");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("true");
    	tempList.add("true reflections");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("dido");
    	tempList.add("drive in drive out");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("lyd");
    	tempList.add("let you down");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("liog");
    	tempList.add("lie in our graves");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("proudest");
    	tempList.add("pm");
    	tempList.add("proudest monkey");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("smts");
    	tempList.add("so much to say");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("billies");
    	tempList.add("tripping billies");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("byah");
    	tempList.add("build you a house");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ggt");
    	tempList.add("good good time");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ioy");
    	tempList.add("idea of you");
    	tempList.add("the idea of you");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ktk");
    	tempList.add("kill the king");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("lw");
    	tempList.add("loving wings");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("suad");
    	tempList.add("sweet up and down");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("astb");
    	tempList.add("anyone seen the bridge");
    	tempList.add("anyone seen the bridge?");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("wwbom");
    	tempList.add("what will become of me");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ftwii");
    	tempList.add("funny");
    	tempList.add("funny the way it is");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("lithog");
    	tempList.add("lying in the hands of god");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("smlam");
    	tempList.add("shake me like a monkey");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("wia");
    	tempList.add("why i am");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("you & me");
    	tempList.add("you and me");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("bef");
    	tempList.add("big eyed fish");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("dad");
    	tempList.add("digging a ditch");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("gig");
    	tempList.add("grace is gone");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("kkj");
    	tempList.add("kit kat jam");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("wayg");
    	tempList.add("where are you going");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ynk");
    	tempList.add("you never know");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ants");
    	tempList.add("ants marching");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("bowa");
    	tempList.add("best of what's around");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("jimi");
    	tempList.add("jimi thing");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("lld");
    	tempList.add("lover lay down");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("pfwyg");
    	tempList.add("pay for what you get");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("rhyme");
    	tempList.add("rhyme & reason");
    	tempList.add("rhyme and reason");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("typical");
    	tempList.add("typical situation");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("wwys");
    	tempList.add("what would you say");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("dftr");
    	tempList.add("reaper");
    	tempList.add("the reaper");
    	tempList.add("don't fear the reaper");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("afm");
    	tempList.add("angel from montgomery");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("bdth");
    	tempList.add("burning down the house");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("cortez");
    	tempList.add("cortez the killer");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("dbtr");
    	tempList.add("down by the river");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("fitr");
    	tempList.add("fool in the rain");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ftbow");
    	tempList.add("for the beauty of wynona");
    	tempList.add("beauty of wynona");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("fhtsa");
    	tempList.add("funny how time slips away");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("gtbt");
    	tempList.add("good times bad times");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("hhmm");
    	tempList.add("hey hey my my");
    	tempList.add("hey hey my my into the black");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("maker");
    	tempList.add("the maker");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("lbv");
    	tempList.add("long black veil");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("majdbts");
    	tempList.add("me and julio down by the schoolyard");
    	tempList.add("me and julio");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("needle and the damage down");
    	tempList.add("the needle and the damage done");
    	tempList.add("tnatdd");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("siu");
    	tempList.add("stir it up");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("thank you");
    	tempList.add("thank you falettinme be mice elf agin");
    	tempList.add("tyfbmea");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("tots");
    	tempList.add("time of the season");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("abi");
    	tempList.add("american baby intro");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ewu");
    	tempList.add("everybody wake up");
    	tempList.add("everybody wake up (our finest hour arrives)");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("bayou");
    	tempList.add("louisiana bayou");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("odh");
    	tempList.add("old dirt hill");
    	tempList.add("old dirt hill (bring that beat back)");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("oomh");
    	tempList.add("out of my hands");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("stand up");
    	tempList.add("stand up (for it)");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("steady");
    	tempList.add("steady as we go");
    	tempList.add("sawg");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("stolen away");
    	tempList.add("stolen away on 55th & 3rd");
    	tempList.add("stolen away on 55th and 3rd");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ymdt");
    	tempList.add("die trying");
    	tempList.add("you might die trying");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("dreams of our fathers");
    	tempList.add("doof");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ftt");
    	tempList.add("fool to think");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("idi");
    	tempList.add("i did it");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("iihia");
    	tempList.add("if i had it all");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("stdh");
    	tempList.add("sleep to dream her");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("tsb");
    	tempList.add("the space between");
    	tempList.add("space between");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("wya");
    	tempList.add("what you are");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("wtwe");
    	tempList.add("when the world ends");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ibyu");
    	tempList.add("i'll back you up");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("osw");
    	tempList.add("one sweet world");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("stjl");
    	tempList.add("tstjl");
    	tempList.add("song that jane likes");
    	tempList.add("the song that jane likes");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("loml");
    	tempList.add("love of my life");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("gbe");
    	tempList.add("grey blue eyes");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("sdl");
    	tempList.add("so damn lucky");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("stay or leave");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("too high");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("uaa");
    	tempList.add("up and away");
    	tempList.add("up & away");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("ddtw");
    	tempList.add("don't drink the water");
    	tempList.add("don't drink");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("dreaming tree");
    	tempList.add("the dreaming tree");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("the last stop");
    	tempList.add("last stop");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("pnp");
    	tempList.add("pantala naga pampa");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("stay");
    	tempList.add("stay (wasting time)");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("stone");
    	tempList.add("the stone");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("crash");
    	tempList.add("crash into me");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("hunger");
    	tempList.add("hunger for the great light");
    	tempList.add("hftgl");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("nancies");
    	tempList.add("dancing nancies");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("corn bread");
    	tempList.add("cornbread");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("help myself");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("joyride");
    	tempList.add("joy ride");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("lrb");
    	tempList.add("little red bird");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("write a song");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("watchtower");
    	tempList.add("all along the watchtower");
    	tempList.add("aatw");
    	nameList.add(tempList);
    	tempList = new ArrayList<String>(0);
    	tempList.add("sugarman");
    	tempList.add("sugar man");
    	nameList.add(tempList);
    	symbolList.add("*");
    	symbolList.add("^");
    	symbolList.add("~");
    	symbolList.add("+");
    	symbolList.add("$");
    	symbolList.add("%");
    	symbolList.add("§");
    	symbolList.add("¤");
    	symbolList.add("»");
    	
    }

}
