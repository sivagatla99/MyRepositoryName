package org.clothingrfid.utils;

import java.io.*;
import java.util.*;


public class GetData {
	public static void fromExcel() {

	}

	public static String fromProperties(String filName,String key) throws IOException {
		String value=null;
		File f = new File("./test-config/"+filName+".properties");
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		value = (String)prop.get(key);
		return value;
	}
}
