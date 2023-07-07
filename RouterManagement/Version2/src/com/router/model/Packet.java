package com.router.model;

import com.router.util.DataType;
import com.router.util.PacketSizeCategory;

public class Packet implements Runnable{

    private String id;
    private DataType dataType;
    private PacketSizeCategory packetSizeCategory;
    private long inBoundAt;

    public Packet(String id, DataType dataType, PacketSizeCategory packetSizeCategory) {
        this.id = id;
        this.dataType = dataType;
        this.packetSizeCategory = packetSizeCategory;
        this.inBoundAt = 0l;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public PacketSizeCategory getPacketSizeCategory() {
        return packetSizeCategory;
    }

    public void setPacketSizeCategory(PacketSizeCategory packetSizeCategory) {
        this.packetSizeCategory = packetSizeCategory;
    }

    public long getInBoundAt() {
        return inBoundAt;
    }

    public void setInBoundTime(long inBoundAt) {
        this.inBoundAt = inBoundAt;
    }

    @Override
    public void run() {
        System.out.println("At  time : "+ System.currentTimeMillis() +" : Packet  is getting removed from router  : "+ toString());

    }

    @Override
    public String toString() {
        return "Packet{" +
                "id='" + id + '\'' +
                ", dataType=" + dataType +
                ", packetSizeCategory=" + packetSizeCategory +
                ", inBoundAt=" + inBoundAt +
                '}';
    }


}
