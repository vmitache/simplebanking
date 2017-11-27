package curs.randomaccesslist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class Main {

	public static void main(String[] args) {
		String[] sarray = {
				"Ala",
				"Bala",
				"Portocala"
		};
		List<String> slist = Arrays.asList(sarray);
		//slist.add("pufi");
		loopOverList(new ArrayList<String>(slist));
	}
	
	static void loopOverList(List<String> pList) {
		System.out.println(pList.getClass().getName());
		if(pList instanceof RandomAccess) {
			for(int i=0;i < pList.size();i++) {
				System.out.println("get(" + i + ")=" + pList.get(i));
			}
		} else {
			for(String s : pList) {
				System.out.println("foreach:" + s);
			}
		}
	}

}
