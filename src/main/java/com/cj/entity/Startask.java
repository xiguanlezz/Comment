package com.cj.entity;

public class Startask {
    private Integer tScore;
    private Integer tCount;
    private Integer tBId;

    public Startask() {
    }

    @Override
    public String toString() {
        return "Startask{" +
                "tScore=" + tScore +
                ", tCount=" + tCount +
                ", tBId=" + tBId +
                '}';
    }

    public Integer gettScore() {
        return tScore;
    }

    public void settScore(Integer tScore) {
        this.tScore = tScore;
    }

    public Integer gettCount() {
        return tCount;
    }

    public void settCount(Integer tCount) {
        this.tCount = tCount;
    }

    public Integer gettBId() {
        return tBId;
    }

    public void settBId(Integer tBId) {
        this.tBId = tBId;
    }
}
