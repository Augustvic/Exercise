package Array;

import java.util.Scanner;

public class Magic_Matrix {

	public static void main(String[] args) {
		
		int a[][] = new int[15][15];    //����һ��15*15�ľ���
		int i, j, k, p, n = 0;
		p = 1;

		Scanner sc = new Scanner(System.in);
		//���������������n
		while (p == 1)
		{
			System.out.println("enter n(n=1--15):");     //����1-15������
			n = sc.nextInt();            //n��ʾ���������������
			if ((n != 0) && (n <= 15) && (n % 2 != 0))   //�ж���������Ƿ����Ҫ��
				p = 0;        //p==0����ѭ����ֱ��p==1
		}


		//����ά����(����)����Ԫ�ظ���ֵ0,�����𲽵��Թ۲�i��jֵ�ı仯
		//���鳤��Ϊn,������Χ��0��n-1
		//����i=0��ʾ��һ�У�j=0��ʾ��һ��
		//����ע���У������Ԫ��������Χ�ǵ�0�е���n-1��,������Χ�ǵ�0�е���n-1��
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				a[i][j] = 0;
		//�˲��������i��ֵΪn,j��ֵΪn


		//����1���ڵ�һ���м�һ�У�j��ʾ����
		j = n / 2;
		a[0][j] = 1;
		//�˲��������i��ֵΪn,j��ֵΪ��1������


		//�Ծ����д���2��ʼ����ʣ�µ�Ԫ�ذ���ħ����Ĺ���ֵ
		for (k = 2; k <= n * n; k++)
		{
			i = i - 1;
			j = j + 1;

			if ((i < 0) && (j > n - 1))  //�����ʱΪ��0�У���n-1��
			{
				i = i + 2;     //����һ�����������ϼ�1������ǰ��i=i-1,���Դ˴�i+2
				j = j - 1;      //��������һ����һ��������ǰ��j=j+1,���Դ˴�j-1��ѧϰ�������еĹ��ɣ�5����
			}
			else
			{
				if (i < 0) i = n - 1;      //�����һ����������Ϊ0������һ����������Ϊn-1��ѧϰ�������еĹ��ɣ�3����
										   //����ǰ��j=j+1,�������Ѿ���һ
				if (j > n - 1) j = 0;      //�����һ����������Ϊn-1,����һ����������Ϊ0��ѧϰ�������еĹ��ɣ�2����
										   //����ǰ��i=i-1,�������Ѿ���һ
			}

			if (a[i][j] == 0)     //�����λ��ֵΪ��ֵ0,��ʾ��û�и�ֵ�����������λ��
				a[i][j] = k;
			else
			{
				i = i + 2;
				j = j - 1;
				a[i][j] = k;
			}
		}


		//��ӡħ����
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < n; j++)
				System.out.printf("%5d", a[i][j]);
			System.out.println();
		}
	}
}