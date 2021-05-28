package entity;

import java.sql.Time;

public class TimeSlot {
    private int id;
    private Time timeStart;
    private Time timeEnd;

    public TimeSlot(int id, Time timeStart, Time timeEnd) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public TimeSlot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSlot timeSlot = (TimeSlot) o;

        if (id != timeSlot.id) return false;
        if (!timeStart.equals(timeSlot.timeStart)) return false;
        return timeEnd.equals(timeSlot.timeEnd);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + timeStart.hashCode();
        result = 31 * result + timeEnd.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
