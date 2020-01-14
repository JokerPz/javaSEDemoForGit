package com.joker.lambda;

public class Hero implements Comparable<Hero>{
		
	public String name;
	public float hp;
	public int damage;
	
	public Hero(String name, float hp, int damage) {
		super();
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getHp() {
		return hp;
	}


	public void setHp(float hp) {
		this.hp = hp;
	}


	@Override
	public int compareTo(Hero anotherHero) {
		if(this.damage < anotherHero.damage) {
			return 1;
		} 
		return -1;
	}


	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]";
	}
}
