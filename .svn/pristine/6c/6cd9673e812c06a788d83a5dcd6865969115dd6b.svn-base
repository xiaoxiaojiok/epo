package com.gzgb.epo.util;

import java.util.Random;

/**
 * 随机码生成实用类.
 * 
 */
public class RandomUtil
{
	private final static char[] chars = {'a' ,'b', 'c', 'd', 'e', 'f', 'g', 'h',
		'i','j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
		'x','y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0',
		'1', '2', '3', '4', '5', '6', '7', '8', '9'};

	// 随机数生成器
	private Random r = new Random();
	
	// 唯一实例
	private static RandomUtil random = new RandomUtil();
	
	protected RandomUtil() {}
	
	/**
	 * 获取唯一实例.
	 * @return
	 */
	public static RandomUtil getInstance()
	{
		return random;
	}

	/**
	 * 随机数字字符串.
	 * @param len
	 * @return
	 */
	public String randNumber(int len)
	{
		return randomString(len, 52, 61);
	}

	/**
	 * 随机数字和大小写字母的字符串.
	 * @param len
	 * @return
	 */
	public String randNumberAndAlpha(int len)
	{
		return randomString(len, 0, 62);
	}

	/**
	 * 随机小写字母形式的字符串.
	 * @param len
	 * @return
	 */
	public String randLowerAlpha(int len)
	{
		return randomString(len, 0, 26);
	}

	/**
	 * 随机大写字母形式的字符串.
	 * @param len
	 * @return
	 */
	public String randUpperAlpha(int len)
	{
		return randomString(len, 26, 52);
	}

	/**
	 * 随机大小写混合的字母形式的字符串.
	 * @param len
	 * @return
	 */
	public String randAlpha(int len)
	{
		return randomString(len, 0, 52);
	}
	
	/**
	 * 随机字符生成方法.
	 * @param len
	 * @param start
	 * @param end
	 * @return
	 */
	protected String randomString(int len, int start, int end)
	{
		StringBuilder charValue = new StringBuilder();
		for (int i = 0; i < len; i++) {
			charValue.append(chars[randomInt(start, end)]);
		}
		return charValue.toString();
	}

	/**
	 * 返回[from,to)之间的一个随机整数
	 * 
	 * @param from  起始值
	 * @param to 结束值
	 * @return [from,to)之间的一个随机整数
	 */
	public int randomInt(int from, int to)
	{
		return from + r.nextInt(to - from);
	}
	
	public static void main(String[] args)
	{
		RandomUtil random = RandomUtil.getInstance();
		StringUtil.debug(random.randNumber(20));
		StringUtil.debug(random.randAlpha(20));
		StringUtil.debug(random.randLowerAlpha(20));
		StringUtil.debug(random.randNumberAndAlpha(20));
		StringUtil.debug(random.randUpperAlpha(20));
	}
}
