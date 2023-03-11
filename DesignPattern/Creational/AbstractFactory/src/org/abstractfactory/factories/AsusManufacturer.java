package org.abstractfactory.factories;

import org.abstractfactory.product.AsusGPU;
import org.abstractfactory.product.AsusMonitor;
import org.abstractfactory.product.GPU;
import org.abstractfactory.product.Monitor;

public class AsusManufacturer extends Company{
    @Override
    public GPU createGpu() {
        return new AsusGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
