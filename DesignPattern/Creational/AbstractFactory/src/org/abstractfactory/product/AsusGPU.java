package org.abstractfactory.product;

public  class AsusGPU extends GPU{
    @Override
    public void assemble() {
        System.out.println("Assembling ASUS GPU....");
    }
}
