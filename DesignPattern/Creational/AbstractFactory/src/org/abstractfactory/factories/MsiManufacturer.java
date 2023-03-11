package org.abstractfactory.factories;

import org.abstractfactory.product.GPU;
import org.abstractfactory.product.Monitor;
import org.abstractfactory.product.MsiGPU;
import org.abstractfactory.product.MsiMonitor;

public class MsiManufacturer extends Company{
    @Override
    public GPU createGpu() {
        return new MsiGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}
