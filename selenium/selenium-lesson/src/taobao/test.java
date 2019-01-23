package taobao;

public class test {
	public  static void main(String[] args)
	{
		long  time = System.currentTimeMillis();
		for(int i=0;i<200000;i++){
			String s1="//li[";
			int  s2 = i;
			String s3 = "]/a";
		String s=s1+s2+s3;
		System.out.println(s);}
		long endtime = System.currentTimeMillis();
		System.out.println(endtime-time);
	}

}
