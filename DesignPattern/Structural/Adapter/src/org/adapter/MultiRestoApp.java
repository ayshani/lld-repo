package org.adapter;

public class MultiRestoApp implements IMultiRestApp{
    @Override
    public void displayMenu(XmlData xmlData) {
        System.out.println("Displaying Menus using XML data.....");
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        System.out.println("Displaying Recommendations using XML data.....");
    }
}
