package orm;

import javax.persistence.*;

@Entity
@Table(name = "CheckedPoint")
public class CheckedPoint {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "x")
    private double x;

    @Column(name = "y")
    private double y;

    @Column(name = "r")
    private int r;

    @Column(name = "result")
    private String result;

    public CheckedPoint(double x, double y, int r, String result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public CheckedPoint() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

}
