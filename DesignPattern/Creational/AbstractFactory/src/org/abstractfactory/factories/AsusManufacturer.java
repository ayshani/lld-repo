package org.abstractfactory.factories;

import org.abstractfactory.product.AsusGPU;
import org.abstractfactory.product.AsusMonitor;
import org.abstractfactory.product.GPU;
import org.abstractfactory.product.Monitor;

//This is one of the Concrete Implementation of abstract factory
//Which is responsible for creating different Type of object(Particular type(in this case Asus) of an object)
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
