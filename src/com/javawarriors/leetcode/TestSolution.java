package com.javawarriors.leetcode;

public class TestSolution {

	public static void main(String[] args) {
		/*
		 * String[] array = { "..4...63.", ".........", "5......9.",
		 * "...56....", "4.3.....1", "...7.....", "...5.....", ".........",
		 * "........." }; char[][] board = new char[9][9]; for (int i = 0; i <
		 * 9; i++) { board [i] = array[i].toCharArray(); }
		 */
		SortedArrayToBSTSolution sol = new SortedArrayToBSTSolution();
		/*
		 * LRUCache cache = new LRUCache(2); System.out.println(cache.get(2));
		 * cache.set(2,6); System.out.println(cache.get(1)); cache.set(1,5);
		 * cache.set(1,2); System.out.println(cache.get(1));
		 * System.out.println(cache.get(2));
		 */
		System.out.println(sol.sortedArrayToBST(new int[]{1,3}));
		// System.out.println(sol.isValidSudoku(board));
		// System.out.println(sol.isPalindrome("aA"));
		// System.out.println(sol.search(new int[]{1,3,5}, 1));
		// System.out.println(sol.findSubstring("barfoothefoobarman", new
		// String[]{"foo","bar"}));
		// System.out.println(sol.findSubstring("abababab", new
		// String[]{"a","b","a"}));
		// System.out.println(sol.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
		// new String[]{"fooo","barr","wing","ding","wing"}));
		// System.out.println(sol.findSubstring("syvsjefxttjyqamnntfucrpeoculzlzsjukuarrtmbuddiqsbxmdodjdffqfrpzcjjxmcofprzuwikpjhbpxhycmettxiuzufwginlxgnrdxduimxxjewmtchmzpjyjovrwifvqsmtprpxdnxprtdkvkzuziulwpcvzhqqbflswbscqprhiuufetbfdvsznvwoengisuaqvssnhjurfoyljbrmzjomgkcnxjvrdviaqanzmjtrardjvwwufmgowibwtwnwtxwjyljmvcfvvigqgekmqscpddlwbatuyreyfpkarpxoadhgiruamyppbancdgxbadbfsnhleezejgntajumijdlmqqpzpqbstgkgpxkvwpefeyfpstzdwlpodenswokpwwvltgirxpydndshyumwhclkiycfpoulmszhyjyxyzancuwdojzxlkhtllaczxpnpqupavmyuomykibbrbyengaarcctzsgoibdkyrjsfvqqfurzvpfkxfnripkjjqyutdervnlckcuqylrtdwfccstmkfxtwvprbulwjwawavoyiftnbbqftltfrrbpmqgpmtlysouujivrpqfqrxwnirszitoxmxmyqaykosfxcaqtqvkksizbzrcknrhbotbgvarjuyizyzsquccpmbsovuyklflbamiwobhjzqkzpcrlhuctxuhsrhcempgpeqlsrudsknrbskpzerscocwfjbjyqpnuhapauushklicwxdcpxgdzfklgtlwlatsaktwgndqzouxlxbcxihwprjvlwtwwoqyyjvhzaxaouxataeqkmpzdauqxomtcfudopkprjpgdoizpmpzyezehvuejhzomtrckbsckjiqyspnegofnnjujdaukziytbddcxhpgphghytogkttxcpifpdsrnsmpxrtuzkdqtlathoarhvollzqcektrdficxezwocmkpmdwcdnlzcwmdpohziaepjhmngkdkznznrwqwlbvnahspwzqgaxvlgkyoudatrzhkxzgjceycnttlskruhpfpzfdtldpceyoexwpbcpeqixbbjtxskfhjkkcvntzsrpyomnqocwglviofdlznqhwdrayhuablrzcdmuuosabnkpunbuatbywubxdvzeiqfmuriqiasjodzkqcetvhtueurhpqoaitmcnvuxxngnqhyiledhoxdsrubjmpjujxzysvvsidfaldlyiofylkqferoshxnsuospjnhusmwfsjecylalwqqajevsdkmayerjtyfmmcrglviljkxfcpfmwcgzmtzmzqwtqdhffaltywghgfmlvtxrwdskyuxymvtfyakgaxbavhhentpknobltvvspsscpljontwpsxqoexuttjdizgtscqmtlexapgqcbmsulkkqhelappiovdizuvvfzsfrbyvckpywzkojqzjhquxmxgnrdiyedgxgetkqklomvcvoeevuatiybwregsilyirebcunnjzknuytbuobpwbquvwdngonogrrknfzyejobihcevftuhloehrtnggcoztamaznfibgqikweppayaochivxqdbgcwgrxfeenfmgnwctnstmukqeuobkreqwawnxbtdqypwnlbjztenpodtitwulakhbiwajpecptyehzniusvmiaftucnhe",
		// new
		// String[]{"qbflswbscqprhiuufetbfd","vsznvwoengisuaqvssnhju","rfoyljbrmzjomgkcnxjvrd","viaqanzmjtrardjvwwufmg","owibwtwnwtxwjyljmvcfvv","igqgekmqscpddlwbatuyre","yfpkarpxoadhgiruamyppb","ancdgxbadbfsnhleezejgn","tajumijdlmqqpzpqbstgkg","pxkvwpefeyfpstzdwlpode","nswokpwwvltgirxpydndsh","yumwhclkiycfpoulmszhyj","yxyzancuwdojzxlkhtllac","zxpnpqupavmyuomykibbrb","yengaarcctzsgoibdkyrjs","fvqqfurzvpfkxfnripkjjq","yutdervnlckcuqylrtdwfc","cstmkfxtwvprbulwjwawav","oyiftnbbqftltfrrbpmqgp","mtlysouujivrpqfqrxwnir"}));
		// System.out.println(sol.findSubstring("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab",
		// new
		// String[]{"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"}));
	}
}
