package com.router.util;

import com.router.model.Packet;

import java.util.Comparator;

public class RouterEvictionComparator implements Comparator<Packet> {
    @Override
    public int compare(Packet packetA, Packet packetB) {
        if(packetA.getDataType().getPriority() != packetB.getDataType().getPriority()){
            return packetA.getDataType().getPriority() - packetB.getDataType().getPriority();
        } else if(packetA.getPacketSizeCategory().getOrder()!=packetB.getPacketSizeCategory().getOrder()){
            return packetA.getPacketSizeCategory().getOrder() - (packetB.getPacketSizeCategory().getOrder());
        } else
            return (int)(packetA.getInBoundAt()-packetB.getInBoundAt());
    }
}
