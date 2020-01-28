package Array;

import java.util.Scanner;

public class Magic_Matrix {

	public static void main(String[] args) {
		
		int a[][] = new int[15][15];    //定义一个15*15的矩阵
		int i, j, k, p, n = 0;
		p = 1;

		Scanner sc = new Scanner(System.in);
		//矩阵的行数和列数n
		while (p == 1)
		{
			System.out.println("enter n(n=1--15):");     //输入1-15的奇数
			n = sc.nextInt();            //n表示矩阵的行数和列数
			if ((n != 0) && (n <= 15) && (n % 2 != 0))   //判断输入的数是否符合要求
				p = 0;        //p==0继续循环，直到p==1
		}


		//给二维数组(矩阵)所有元素赋初值0,建议逐步调试观察i和j值的变化
		//数组长度为n,索引范围是0到n-1
		//所以i=0表示第一行，j=0表示第一列
		//以下注释中，矩阵的元素行数范围是第0行到第n-1行,列数范围是第0列到第n-1列
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				a[i][j] = 0;
		//此步骤结束后，i的值为n,j的值为n


		//将数1放在第一行中间一列，j表示列数
		j = n / 2;
		a[0][j] = 1;
		//此步骤结束后i的值为n,j的值为数1的列数


		//对矩阵中从数2开始所有剩下的元素按照魔方阵的规则赋值
		for (k = 2; k <= n * n; k++)
		{
			i = i - 1;
			j = j + 1;

			if ((i < 0) && (j > n - 1))  //如果此时为第0行，第n-1列
			{
				i = i + 2;     //在上一个数的行数上加1，由于前面i=i-1,所以此处i+2
				j = j - 1;      //列数和上一个数一样，由于前面j=j+1,所以此处j-1（学习辅导答案中的规律（5））
			}
			else
			{
				if (i < 0) i = n - 1;      //如果上一个数的行数为0，则下一个数的行数为n-1（学习辅导答案中的规律（3））
										   //由于前面j=j+1,即列数已经加一
				if (j > n - 1) j = 0;      //如果上一个数的列数为n-1,则下一个数的列数为0（学习辅导答案中的规律（2））
										   //由于前面i=i-1,即行数已经减一
			}

			if (a[i][j] == 0)     //如果该位置值为初值0,表示还没有赋值，可以填入该位置
				a[i][j] = k;
			else
			{
				i = i + 2;
				j = j - 1;
				a[i][j] = k;
			}
		}


		//打印魔方阵
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < n; j++)
				System.out.printf("%5d", a[i][j]);
			System.out.println();
		}
	}
}
