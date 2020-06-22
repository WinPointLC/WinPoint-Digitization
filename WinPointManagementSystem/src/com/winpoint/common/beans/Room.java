package com.winpoint.common.beans;

/**
 * @author shraddhapadalkar
 *
 */
public class Room {
	
	private Integer roomId;
	private Integer roomCapacity;
	private Boolean roomAvailable;
	
	
	/**
	 * @param roomId;
	 * @param roomCapacity;
	 * @param roomAvailable
	 */
	
	
	public Room(Integer roomId, Integer roomCapacity, Boolean roomAvailable) {
		super();
		this.roomId = roomId;
		this.roomCapacity = roomCapacity;
		this.roomAvailable = roomAvailable;
	}

	/**
	 * @return the roomId
	 */
	public Integer getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}


	/**
	 * @return the roomCapacity
	 */
	public Integer getRoomCapacity() {
		return roomCapacity;
	}

	/**
	 * @param roomCapacity the roomCapacity to set
	 */
	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	/**
	 * @return the roomAvailable
	 */
	public Boolean getRoomAvailable() {
		return roomAvailable;
	}

	/**
	 * @param roomAvailable the roomAvailable to set
	 */
	public void setRoomAvailable(Boolean roomAvailable) {
		this.roomAvailable = roomAvailable;
	}
	
}
