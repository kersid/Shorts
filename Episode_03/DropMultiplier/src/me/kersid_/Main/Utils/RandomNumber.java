package me.kersid_.Main.Utils;

import java.util.Random;

public class RandomNumber {
	
	public static int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.ints(min, (max)).findFirst().getAsInt();
	}
}
