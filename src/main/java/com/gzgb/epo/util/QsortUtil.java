package com.gzgb.epo.util;

import java.util.Arrays;

/**
 * 
 * <pre>
 * 快速排序实用类,对原数组倒序排序，并得到排序后数组元素在排序前的下标
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-11
 */
public class QsortUtil {
	/**
	 * 
	 * <pre>
	 * 倒序排序
	 * </pre>
	 * @param a 原数组
	 * @param m 原数组元素对应下标
	 * @param p 从位置p开始
	 * @param r 到位置r为止
	 * @return
	 */
	public int partion(int a[],int m[],int p,int r)
	{
		int i=p;
		int j=r+1;
		int x=a[p];
		int kk=m[p];
		while(true)
		    {
				while(a[++i]>x&&i<r);
				while(a[--j]<x);
				if(i>=j) break;
				int t=a[i];
				a[i]=a[j];
				a[j]=t;
				t=m[i];
				m[i]=m[j];
				m[j]=t;
		    }
		a[p]=a[j];
		a[j]=x;
		m[p]=m[j];
		m[j]=kk;
		return j;
	}
	
	public void qsort(int a[],int m[],int p,int r)
	{
		if(p<r)
		{
			int q=partion(a,m,p,r);
			qsort(a,m,p,q-1);
			qsort(a,m,q+1,r);
		}
	}
	public static void main(String[] args) {
		int[] a={5,2,6,8,2};
		int[] m=new int[a.length];
		for(int i=0;i<a.length;i++){
			m[i]=i;
		}
		new QsortUtil().qsort(a,m,0,a.length-1);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(m));
	}

}
