package com.hui.drools;

public class Sprinkler {
	private Room room;
	private boolean on;
	public Sprinkler() {
	}
	public Sprinkler(Room room2) {
		room = room2;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	
}
