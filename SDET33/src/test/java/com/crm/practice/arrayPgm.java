package com.crm.practice;

public class arrayPgm {
	public static void main(String[] args) {
		int[] arr= {3,5,1,7,8};
		String s="key3";
		int number=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)>='0' && s.charAt(i)<='9' )
			{
				number=number*10+s.charAt(i)-48;
			}
		}
		for(int i=0; i<number;i++)
		{
			int temp=arr[0];
			for(int j=1; j<arr.length;j++)
			{
				arr[j-1]=arr[j];
			}
			arr[arr.length-1]=temp;
		}
		for(int k=0; k<arr.length;k++)
		{
			System.out.print(arr[k]+" ");
		}
	}
}
