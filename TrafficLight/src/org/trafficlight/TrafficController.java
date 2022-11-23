package org.trafficlight;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {

    private Map<Direction,LightMediator> directionLightMediatorMap;
    final static Map<Direction,Direction> directionMapper = new HashMap<>();
    private boolean isStop;
    static {
        directionMapper.put(Direction.EAST,Direction.WEST);
        directionMapper.put(Direction.NORTH,Direction.SOUTH);
        directionMapper.put(Direction.WEST,Direction.EAST);
        directionMapper.put(Direction.SOUTH,Direction.NORTH);
    }
    public TrafficController(){
        this.directionLightMediatorMap = new HashMap<>();
        this.isStop = false;
    }

    public void addLightMediator(Direction direction,LightMediator lightMediator){
        this.directionLightMediatorMap.put(direction,lightMediator);
    }

    public void startTraffic(Direction direction){
        directionLightMediatorMap.values().forEach(lightMediator -> lightMediator.turnONLight(Color.RED));

    }

}
