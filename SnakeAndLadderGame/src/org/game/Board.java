package org.game;

import lombok.Getter;

import java.util.*;

@Getter
public class Board {

    private int size;
    private int start;
    private int end;

    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size) {
        this.start =1;
        this.size = size;
        this.end = start+size-1;
    }

    public void addSnakesAndLadders(int numberOfSnakes, int numberOfLadders){
        snakes = new ArrayList<>(numberOfSnakes);
        ladders = new ArrayList<>(numberOfLadders);

        Set<String> occupiedPositions = new HashSet<>();

        for(int i=0;i<numberOfSnakes;i++){
            while(true){
                int head = new Random().nextInt(this.end+1 - this.start)+ this.start;
                int tail = new Random().nextInt(this.end+1 - this.start)+ this.start;
                if(tail>=head)
                    continue;

                String headTailPair = head + " " + tail;
                String tailHeadPair = tail + " " + head;
                if(!occupiedPositions.contains(headTailPair) && !occupiedPositions.contains(tailHeadPair)){
                    Snake snake = new Snake(head,tail);
                    this.getSnakes().add(snake);
                    occupiedPositions.add(headTailPair);
                    occupiedPositions.add(tailHeadPair);
                    break;
                }
            }
        }

        for(int i=0;i<numberOfLadders;i++){
            while(true){
                int startLadder = new Random().nextInt(this.end+1 - this.start)+ this.start;
                int endLadder = new Random().nextInt(this.end+1 - this.start)+ this.start;
                if(endLadder<=startLadder)
                    continue;

                String headTailPair = String.valueOf(startLadder+" ")+endLadder;
                String tailHeadPair = String.valueOf(endLadder+" ")+startLadder;
                if(!occupiedPositions.contains(headTailPair) && !occupiedPositions.contains(tailHeadPair)){
                    Ladder ladder = new Ladder(startLadder,endLadder);
                    this.getLadders().add(ladder);
                    occupiedPositions.add(headTailPair);
                    occupiedPositions.add(tailHeadPair);
                    break;
                }
            }
        }
    }

    public int getNewPositionAfterGoingThroughSnakesAndLadders(int currentPosition){
            for(Snake snake : this.getSnakes()){
                if(snake.getHead()==currentPosition)
                {
                    System.out.println("Snake bites at "+ snake.getHead());
                    return snake.getTail();
                }
            }

            for(Ladder ladder : this.getLadders()){
                if(ladder.getStart()==currentPosition){
                    System.out.println("Climbed Ladder at "+ ladder.getStart());
                    return ladder.getEnd();
                }
            }
            // If we don't get any snake/ladder, that means we can stay on the currentPosition
            return currentPosition;
    }
}
