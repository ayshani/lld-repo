package org.abstractfactory.factories;

import org.abstractfactory.product.GPU;
import org.abstractfactory.product.Monitor;
import org.abstractfactory.product.MsiGPU;
import org.abstractfactory.product.MsiMonitor;

//This is one of the Concrete Implementation of abstract factory
//Which is responsible for creating different Type of object(Particular type(in this case Msi) of an object)
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
