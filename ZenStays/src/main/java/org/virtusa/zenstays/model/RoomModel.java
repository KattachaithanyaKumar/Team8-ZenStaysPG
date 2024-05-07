package org.virtusa.zenstays.model;

public class RoomModel {
    private int roomId;
    private boolean availability;
    private int pgId;
    private int noOfBeds;
    int type;
    PGModel pg;
    
    public RoomModel() {
        
    }

    public RoomModel(int room_id, int type, boolean availability, PGModel pg) {
        this.roomId = room_id;
        this.type = type;
        this.availability = availability;
        this.pg = pg;
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

    public int getType() {
        return type;
    }

    public PGModel getPg() {
        return pg;
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
