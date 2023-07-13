package com.ippo.library.entity;

import com.ippo.library.constant.Constants;

/**
 *
 * 2021/11/16 1:50
 */
public enum Position {

    /**
     *
     */
    NORTH(0, "north", 3, 1),
    EAST(1, "east", 0, 2),
    SOUTH(2, "south", 1, 3),
    WEST(3, "west", 2, 0);

    private int index;

    private String name;

    private int leftNextIndex;

    private int rightNextIndex;

    Position(int index, String name, int leftNextIndex, int rightNextIndex) {
        this.index = index;
        this.name = name;
        this.leftNextIndex = leftNextIndex;
        this.rightNextIndex = rightNextIndex;
    }

    public Position getNewPosition(Position position, String operate) {
        int goalIndex = 0;
        switch (operate) {
            case Constants.LEFT:
                goalIndex = position.getLeftNextIndex();
                break;
            case Constants.RIGHT:
                goalIndex = position.getRightNextIndex();
                break;
            default:
                break;
        }
        switch (goalIndex) {
            case 0:
                return NORTH;
            case 1:
                return EAST;
            case 2:
                return SOUTH;
            case 3:
                return WEST;
            default:
                return null;
        }
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    private int getLeftNextIndex() {
        return leftNextIndex;
    }

    private int getRightNextIndex() {
        return rightNextIndex;
    }

    @Override
    public String toString() {
        return "Position{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", leftNextIndex=" + leftNextIndex +
                ", rightNextIndex=" + rightNextIndex +
                '}';
    }

}
