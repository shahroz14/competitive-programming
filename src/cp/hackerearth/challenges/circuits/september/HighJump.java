package cp.hackerearth.challenges.circuits.september;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HighJump {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int l = in.nextInt();
		int a = in.nextInt();

		Obstacle[] obstacles = new Obstacle[n];

		for (int i = 0; i < n; i++)
			obstacles[i] = new Obstacle(in.nextInt(), in.nextInt());

		in.close();
	}

	public static boolean isPossible(int n, int m, int l, int a, Obstacle[] obstacles) {
		
		int pos = obstacles[0].pos;
		int hi = obstacles[0].height;
		
		List<String>
		
		if(pos-(hi/a) < 0)
			return false;
		
		for(int i=1; i<n-1; i++) {
			pos = obstacles[i].pos;
			hi = obstacles[i].height;
			
		}
		
		return true;
	}

}

class Obstacle implements Comparable<Obstacle> {

	int pos;
	int height;

	public Obstacle(int pos, int height) {
		this.pos = pos;
		this.height = height;
	}

	@Override
	public int compareTo(Obstacle obs) {
		return pos - obs.pos;
	}

}
