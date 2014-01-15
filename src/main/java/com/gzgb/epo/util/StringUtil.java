package com.gzgb.epo.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;


/**
 * 字符串实用方法类。
 * 
 */
public class StringUtil
{
	public static String null2Blank(String str){
		if(str==null){return "";}
		return str;
	}
	
	public static String null2blank(String s){
		if(s==null || "null".equals(s)){
			return "";
		} else {
			return s;
		}
	}
	public static Integer null2Zero(Integer i){
		if(i==null){
			return 0;
		} else {
			return i;
		}
	}
	
	//获取字符串的长度,中文占一个3位,英文、数字及符号占1个位，. 
	public static int length(String str){ 
	   int strlen=0; 	   
	   if(str == null){   
		   str = ""; 
	   }
	   char[] a = str.toCharArray(); 
	   for(int i = 0;i <a.length;i++){ 
	       if(a[i] < 255){ 
	               strlen++;
	       } 
	       else{ 
	           strlen++; 
	           strlen++;
	           strlen++;
	       } 
	   } 
	   return strlen; 
	} 
	
	//重新组合字符串,中文占一个位,英文、数字及符号占0.5个位，也就是2个英文占一个位. 
	public static String substring(String str, double length){ 
		   String textStr = "";
		   if(str == null)   
			   str= ""; 
		   int i;
		   char[] a = str.toCharArray(); 
		   for(i = 0; i < length; i++){
			   if(a[i] < 255){
				   length = length + 0.5;
			   }
		   }
		   for(i = 0; i < length;i++){ 
		            textStr = textStr + a[i];
		   } 
		   return textStr; 
		} 

	/**获取字符串, 
	*   str为标题字串 
	*   len为要截取的长度, 
	*   addstr为截取后字串尾追加的标识字串*/ 
	public static String subTitle(String str, int len, String addstr){ 
	  if(str == null)   
		  return ""; 
	  if(addstr == null)  
		  addstr= ""; 
	  if(len < 0)   
		  return   null; 
	  if(StringUtil.length(str) > len){ 
	      str = StringUtil.substring(str, len-1) + addstr; 
	  } 
	  return str; 
	} 
	
	
	
	//判断字符串trim后非空 ,非空为true
	public   static   boolean   stringTrim(String   str){ 
		if (str == null) return false;
		str = str.trim();
		if("".equals(str)){
			return false;
		}
		return true; 
	}	
	//如果只有英文和数字,返回true 
	public   static   boolean   isEngString(String   str){ 
		if(str==null) return true;
        str   =   str.trim(); 
        String   arg   =   "^[A-Za-z0-9]+$"; 
        return   str.matches(arg); 
	}
	//如果只有数字,返回true 
	public   static   boolean   isNumString(String   str){     
		if(str==null) return true;
        str   =   str.trim(); 
        String   arg   =   "^[0-9]*[1-9][0-9]*$"; 
        return   str.matches(arg); 
	}
	
	/**
	 * 防止subString报错
	 * @param s
	 * @param beginIndex
	 * @param endIndex
	 * @param returnNull
	 * @return
	 */
	public static String subString(String s, int beginIndex, int endIndex, boolean returnNull){
		String result = "";
		try{
			if(endIndex == 0){
				result = s.substring(beginIndex);
			}else{
				result = s.substring(beginIndex, endIndex);
			}
		}catch(Exception e){
			if(returnNull){
				result = ""; 
			}else{
				result = s;
			}
		}
		
		return result;
	}
	
	/**
	 * 把对象转换成String
	 */
	public final static String toString(Object obj)
	{
		return obj == null ? "" : obj.toString();
	}

	/**
	 * 调式方法
	 */
	public final static void debug(Object obj)
	{
		System.out.println("[DEBUG]:" + toString(obj));
	}

	/**
	 * 调式方法
	 */
	public final static void debug(Object[] obj)
	{
		for (Object tmp : obj) debug(tmp);
	}

	/**
	 * 过滤将要写入到XML文件中的字符串，即过滤掉<![CDATA[和]]>标签
	 */
	public static String toXMLFilter(Object obj)
	{
		if (trim(obj).equals("")) return " ";
		return trim(obj).replaceAll("<!\\[CDATA\\[", "&lt;!CDATA").replaceAll(
				"\\]\\]>", "]] >");
	}

	/**
	 * 返回一个对象的字符串，多数是处理字符串的
	 */
	public static String trim(Object obj)
	{
		return obj == null ? "" : String.valueOf(obj).trim();
	}
	
	/**
	 * 对一字符串数组进行去空格操作
	 */
	public final static String[] trim(String[] aStr)
	{
		if (aStr == null) return null;
		for (int i = 0; i < aStr.length; i ++) {
			aStr[i] = trim(aStr[i]);
		}
		return aStr;
	}
	
	/**
	 * 过滤设置到SQL语句中的字符串
	 */
	public final static String toDBFilter(String aStr)
	{
		return trim(aStr).replaceAll("\\\'", "''");
	}
	
	/**
	 * 数字字符串的整型转换
	 * @param str 数字字符串
	 * @param defaultVal 默认值
	 * @return 转换后的结果
	 */
	public final static int parseInt(String str, int defaultVal)
	{
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException ex) {
			return defaultVal;
		}
	}
	
	/**
	 * 数字字符串的长整型转换
	 * @param str 数字字符串
	 * @param defaultVal 默认值
	 * @return 转换后的结果
	 */
	public final static long parseLong(String str, long defaultVal)
	{
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException ex) {
			return defaultVal;
		}
	}
	
	/**
	 * 数字字符串的整型转换
	 * @param str 数字字符串
	 * @param defaultVal 默认值
	 * @return 转换后的结果
	 */
	public final static int[] parseInt(String[] str, int defaultVal)
	{
		if (str == null || str.length < 1) return new int[0];
		int[] result = new int[str.length];
		for (int i = 0; i < str.length; i ++) {
			result[i] = parseInt(str[i], defaultVal);
		}
		return result;
	}
	
	/**
	 * 将指定的值从源数组中进行排除，并返回一个新数组
	 * @param src
	 * @param target
	 * @return
	 */
	public final static int[] exclude(int[] src, int[] target)
	{
		if (target == null || target.length < 1) return src;
		StringBuilder tmp = new StringBuilder();
		for (int tt : src) {
			if (!include(target, tt)) tmp.append(tt + ",");
		}
		if (tmp.length() > 1 && tmp.charAt(tmp.length() - 1) == ',') {
			tmp.deleteCharAt(tmp.length() - 1);
		}
		if (tmp.toString().trim().length() < 1) return new int[0];
		String[] array = tmp.toString().split(",");
		return parseInt(array, 0);
	}
	
	/**
	 * 将指定的target数组从src源数组中进行排除.
	 * @param src
	 * @param target
	 * @return
	 */
	public final static String[] exclude(String[] src, String[] target)
	{
		if (target == null || target.length < 1) return src;
		StringBuilder tmp = new StringBuilder();
		for (String str : src) {
			if (!include(target, str)) tmp.append(str + ",");
		}
		if (tmp.length() > 1 && tmp.charAt(tmp.length() - 1) == ',') {
			tmp.deleteCharAt(tmp.length() - 1);
		}
		if (tmp.toString().trim().length() < 1) return new String[0];
		return tmp.toString().split(",");
	}
	
	/**
	 * 将指定的数组字符串使用指定的符号进行连接.
	 */
	public final static String join(Object[] src, String spliter)
	{
		if (src == null || src.length < 1) return "";
		StringBuffer tmp = new StringBuffer();
		//String mySpliter = trim(spliter).intern() == "" ? "," : spliter;
		String mySpliter = trim(spliter);
		for (int i = 0; i < src.length; i ++) {
			tmp.append(src[i]);
			if (i < src.length - 1) tmp.append(mySpliter);
		}
		return tmp.toString();
	}
	
	/**
	 * 将指定的数组字符串使用指定的符号进行连接.
	 */
	public final static String join(int[] src, String spliter)
	{
		if (src == null || src.length < 1) return "";
		StringBuffer tmp = new StringBuffer();
		String mySpliter = trim(spliter).intern() == "" ? "," : spliter;
		for (int i = 0; i < src.length; i ++) {
			tmp.append(src[i] + mySpliter);
		}
		return tmp.deleteCharAt(tmp.length() - 1).toString();
	}
	
	/**
	 * 将指定的字符串数组使用指定的字符串进行保围，比如一字符串数组如下：
	 * ["hello", "world"],使用的包围字符串为"'",那么返回的结果就应该是：
	 * ["'hello'","'world'"].
	 * @param src
	 * @param str
	 * @return
	 */
	public final static String[] arround(String[] src, String str)
	{
		if (src == null || src.length < 1) return src;
		String[] result = new String[src.length];
		for (int i = 0; i < src.length; i ++) {
			result[i] = str + src[i] + str;
		}
		return result;
	}
	
	/**
	 * 判断指定的字符串是否是空指针或空串
	 * @param src
	 * @return
	 */
	public final static boolean isNullAndBlank(String src)
	{
		return trim(src).intern() == "";
	}
	
	/**
	 * 将指定的字符串转换成符合JavaBean规范的方法名称！
	 * 此方法将只转换第一个字母为大写字母，比如有一字符串是
	 * helloWorld,那么转换后就是：setHelloWorld.另外如果给出
	 * 的字符串为空（null或""），那么将直接返回空字符串！
	 * @param name
	 * @return
	 */
	public final static String toMethodName(String name)
	{
		String tmp = trim(name).intern();
		if (tmp == "") return "";
		if (tmp.length() < 2) {
			return "set" + name.toUpperCase();
		} else {
			return "set" + name.substring(0, 1).toUpperCase()
				+ name.substring(1);
		}
	}
	
	/**
	 * 利用反射将指定对象的属性打印成字符串形式！
	 * @param obj
	 * @return
	 */
	public final static String reflectObj(Object obj)
	{
		if (obj == null) return "";
		return ReflectionToStringBuilder.reflectionToString(obj);
	}
	
	/**
	 * 将map中的键和值进行对应并返回成字符串.
	 * @param map
	 * @return
	 */
	public final static String mapToString(Map map)
	{
		if (map == null) return null;
		StringBuilder buf = new StringBuilder("[");
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			buf.append(String.valueOf(key) + ":" + String.valueOf(map.get(key)) 
					+ ",");
		}
		if (buf.charAt(buf.length() - 1) == ',') {
			buf.deleteCharAt(buf.length() - 1);
		}
		return buf.append(']').toString();
	}
	
	/**
	 * 检查给定的数组长度是否一致，若全部一致则返回true，否则返回false
	 * @param array
	 * @return
	 */
	public final static boolean sameLength(String[]... array)
	{
		if (array.length <= 1) return true;
		for (int i = 0; i < array.length; i ++) {
			String[] str1 = array[i];
			for (int j = i + 1; j < array.length; j ++) {
				String[] str2 = array[j];
				if (str1 == null && str2 == null) continue;
				if (str1 == null && str2 != null) return false;
				if (str1 != null && str2 == null) return false;
				if (str1.length != str2.length) return false;
			}
		}
		return true;
	}
	
	/**
	 * 检查指定的数组中是否包含了指定的数字.
	 * @param source
	 * @param test
	 * @return
	 */
	public final static boolean include(int[] source, int test)
	{
		if (source == null || source.length < 1) return false;
		for (int tmp : source) {
			if (tmp == test) return true;
		}
		return false;
	}
	
	/**
	 * 检查指定的字符串数组中是否包含了指定的字符串.
	 * @param source
	 * @param test
	 * @return
	 */
	public final static boolean include(String[] source, String test)
	{
		if (source == null || source.length < 1) return false;
		for (String tmp : source) {
			if (tmp == null && test == null) return true;
			if (tmp != null && tmp.equals(test)) return true;
		}
		return false;
	}

	/**
	 * 检查指定的字符串数组中是否包含了指定的字符串，不区分大小写.
	 * @param source
	 * @param test
	 * @return
	 */
	public final static boolean includeIgnoreCase(String[] source, String test)
	{
		if (source == null || source.length < 1) return false;
		for (String tmp : source) {
			if (tmp == null && test == null) return true;
			if (tmp != null && tmp.equalsIgnoreCase(test)) return true;
		}
		return false;
	}
	
	/**
	 * 将指定字符串的首字母变成大写.
	 * @param str
	 * @return
	 */
	public final static String capitalize(String str)
	{
		if (str == null || str.length() < 1) return str;
		if (str.length() == 1) return str.toUpperCase();
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	/**
	 * 将指定字符串的首字母变成小写.
	 * @param str
	 * @return
	 */
	public final static String unCapitalize(String str)
	{
		if (str == null || str.length() < 1) return str;
		if (str.length() == 1) return str.toLowerCase();
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}
	
	/**
	 * 获取当前日期形成的路径字符串.
	 * @return
	 */
	public final static String getDailyDirectory()
	{
		return DateUtil.getFormateDate("yyyy/MM/dd/");
	}
	
	/**
	 * 反转字符串.
	 * @param str
	 * @return
	 */
	public final static String reverse(String str)
	{
		if (trim(str).equals("")) return str;
		return new StringBuilder(str).reverse().toString();
	}

	public final static List<Long []> listToArray(List<Long> list,int bccSize){  
        List<Long []> list2 = new ArrayList<Long []>();  
        Long arr[]=null;  
        for(int j=1,len=list.size()+1;j<len;j++){  
            if(j==1){  
                if(len>bccSize){ //初始化数组大小  
                    arr=new Long[bccSize];  
                }else{  
                    arr=new Long[len-1];  
                }     
            }  
            arr[j-(bccSize*list2.size())-1]=list.get(j-1);  //给数组赋值  
            if(j%bccSize==0){  
                list2.add(arr);  //数组填值满后放到集合中  
                if(len-j-1>bccSize){  
                    arr=new Long[bccSize];  
                //不允许数组有空值创建最后一个数组的大小(如果都要一定大小可以去掉)  
                }else{   
                    arr=new Long[len-(bccSize*list2.size())-1];  
                }     
            }else if(j==len-1){  
                list2.add(arr);//最后一个数组可能没有规定大小  
            }  
        }  
          
        return list2;  
    }
	
	/**
	 * 测试.
	 * @param args
	 */
	public static void main(String[] args)
	{
		StringUtil.debug("toString : " + toString(34567));
		StringUtil.debug("trim : " + trim("   hello world!  "));
		StringUtil.debug("parseInt : " + parseInt("fff", 89));
		StringUtil.debug("join : " + join(new String[]{"hello","world","beijing"}, "="));
		StringUtil.debug("toMethodName:" + toMethodName(null));
		StringUtil.debug("toMethodName:" + toMethodName(""));
		StringUtil.debug("toMethodName:" + toMethodName("e"));
		StringUtil.debug("toMethodName:" + toMethodName("3"));
		StringUtil.debug("toMethodName:" + toMethodName("g3"));
		StringUtil.debug("toMethodName:" + toMethodName("4r"));
		StringUtil.debug("toMethodName:" + toMethodName("gr4fd"));
		int[] a = new int[]{1,2,3}, b = new int[]{2,1,5};
		StringUtil.debug("exclude:" + join(exclude(a, b), ","));
	}
}
