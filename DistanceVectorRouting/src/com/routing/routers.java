package com.routing;

import java.util.Scanner;

// The router class 
public class routers
{
	public int neigh[]; //List of routers neighbors
	public int table[]; //Routers routing table's distance List
	public int nextHop[]; //Routers routing table's next hop list
	
	public routers(int val)
	{
		neigh = new int[DistanceVectorRouting.max];
		table  = new int[DistanceVectorRouting.max];
		nextHop = new int[DistanceVectorRouting.max];
		initialize(val);
	}
	
	//Initializing and building 
	//each routers initial configuration
	public void initialize(int check) 
	{
		int max = DistanceVectorRouting.max;
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER DETAILS FOR ROUTER :"+check);
		for(int i=0;i<max;i++)
		{
			System.out.print("Is router "+(i+1)+" a neighbour (1 for yes and 0 for no):");
			neigh[i] = sc.nextInt();
			if(neigh[i]==1)
			{
				System.out.print("Distance to neighbour "+(i+1)+" :");
				table[i]=sc.nextInt();
			}
			else if((i+1)==check)
			{
				table[i]=0;
			}
			else
			{
				table[i]=100; // Setting infinity to unreachable routers
			}
			System.out.println("");
		}
	}
}


