package com.router.util;

public enum PacketSizeCategory {
    SMALL(2), LARGE(1);


    private int order;

    PacketSizeCategory(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
