package com.routing;

import java.util.Scanner;

public class DistanceVectorRouting 
{
	public static int max,check=1;
	public static Scanner sc = new Scanner(System.in);
	public static routers obj[]; 
	public static DistanceVectorRouting var;
	
	public static void main(String args[])
	{		
		System.out.print("Enter the number of routers :");
		max = sc.nextInt();
		
		obj = new routers[max];
		
		for(int i=0;i<max;i++)
		{
			obj[i] = new routers(check);
			check+=1;
		}
		
		System.out.println("Routing started");
		//Two executions of routing algo
		//to ensure stable config
		route();
		route();
		System.out.println("Routing finished");
		
		//Printing routing table
		for(int i=0;i<max;i++)
		{
			System.out.println("Routing table for router "+(i+1));
			for(int j=0;j<max;j++)
			{
				System.out.println((j+1)+"     "+obj[i].table[j]+"     "+obj[i].nextHop[j]);
			}
			System.out.println("");
		}
		
		
	}
	
	public static void route()
	{
		//To go through all routers
		for(int k=0;k<max;k++)
		{
			//To go through all neighbours of given router
			for(int i=0;i<max;i++)
			{
				if(obj[k].neigh[i]==1)
				{
					//To go through all values of table
					for(int j=0;j<max;j++)
					{
						
						int currentValue = obj[k].table[j];
						int newValue = obj[i].table[j]+obj[k].table[i];
						
						if(currentValue>newValue)
						{
							obj[k].table[j]=newValue;
							if(obj[k].nextHop[i]==0)
								obj[k].nextHop[j]=(i+1);
							else
								obj[k].nextHop[j]=obj[k].nextHop[i];
						}
					}
					
				}
			}
		}
	}
}

