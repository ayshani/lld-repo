package org.adapter;

// This is the new Adapter which is required to be adapted to use old XML data
// here FancyUIService is a JSON data handling class. As we need to use XmlData in the APP
// from User end, so we need to use this implemented based class to conver the XML to JSON
public class FancyUIServiceAdapter implements IMultiRestApp{


    private final FancyUIService fancyUIService;

    public FancyUIServiceAdapter(){
        this.fancyUIService = new FancyUIService();
    }
    @Override
    public void displayMenu(XmlData xmlData) {
        JsonData jsonData = convertToJSON(xmlData);
        System.out.println("Preparing Fancy menus using converted JSON Data Adapter....");
        fancyUIService.displayMenu(jsonData);
    }

    private JsonData convertToJSON(XmlData xmlData) {
        System.out.println("Converting XML to JSON....");
        return new JsonData();
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        JsonData jsonData = convertToJSON(xmlData);
        System.out.println("Preparing Fancy Recommendation using converted JSON Data Adapter....");
        fancyUIService.displayRecommendations(jsonData);
    }
}
