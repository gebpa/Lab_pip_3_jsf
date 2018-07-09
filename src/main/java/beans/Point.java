package beans;

import orm.CheckedPoint;
import orm.CheckedPointService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class Point implements Serializable{
    private List<CheckedPoint> pointsList = new ArrayList<CheckedPoint> ();

    public void updatePoint() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        for (CheckedPoint checkedPoint : new CheckedPointService ().getAllPoints ()){
            checkedPoint.setR (r);
            checkedPoint.setResult(calculateResult (r, checkedPoint.getX (), checkedPoint.getY ()));
            new CheckedPointService().update(checkedPoint);
        }
    }

    private int i;

    public List<CheckedPoint> getPointsList() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        return new CheckedPointService ().getAllPoints ();
    }

    public void setPointsList(List<CheckedPoint> pointsList) {
        this.pointsList = pointsList;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
        try{
        calculateResult ();}
        catch (Exception e){}
    }

    private String picture="graphInit.png";

    private double x;

    private double y;

    private int r;

    private String result;

   public Point(){
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
        this.picture="graph"+r+".png";
        try{
        updatePoint ();}
        catch (Exception e){

        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void calculateResult() throws ClassNotFoundException, SQLException {
        if (x<=0 & y<=0 & x>=-r & y>=-r/2.0 ){
            result="Попали";
        }
        else if(x>=0 & y>=0 & x<=r/2.0 & y<=r/2.0 & y*y+x*x<=(r/2.0)*(r/2.0)){
            result="Попали";
        }
        else if(x<=0 & y>=0 & x>=-r/1.0 & y<=r/1.0 & x+r/1.0>=y){
            result="Попали";
        }
        else result="Промахнулись";
        CheckedPointService service = new CheckedPointService();
        service.add(new CheckedPoint (x, y, r, result));
    }
    public String calculateResult(int r, double x, double y){
        if (x<=0 & y<=0 & x>=-r & y>=-r/2.0 ){
            return "Попали";
        }
        else if(x>=0 & y>=0 & x<=r/2.0 & y<=r/2.0 & y*y+x*x<=(r/2.0)*(r/2.0)){
            return "Попали";
        }
        else if(x<=0 & y>=0 & x>=-r/1.0 & y<=r/1.0 & x+r/1.0>=y){
            return "Попали";
        }
        else return "Промахнулись";
    }
}
