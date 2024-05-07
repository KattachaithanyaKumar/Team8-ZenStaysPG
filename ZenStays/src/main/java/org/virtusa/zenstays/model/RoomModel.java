package org.virtusa.zenstays.model;

public class RoomModel {
    private int roomId;
    private boolean availability;
    private int pgId;
    private int noOfBeds;

    public RoomModel() {
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getPgId() {
        return pgId;
    }

    public void setPgId(int pgId) {
        this.pgId = pgId;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    @Override
    public String toString() {
        return "RoomModel{" +
                "roomId=" + roomId +
                ", availability=" + availability +
                ", pgId=" + pgId +
                ", noOfBeds=" + noOfBeds +
                '}';
    }
}
