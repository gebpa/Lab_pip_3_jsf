package beans;

import orm.CheckedPoint;
import orm.CheckedPointService;
//
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@ManagedBean
//@ApplicationScoped
//public class ListOfPoints {
//    @ManagedProperty(value = "#{point}")
//    private Point point;
//
//
//
//    public List<CheckedPoint> getPointsList() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
//        return new CheckedPointService ().getAllPoints ();
//    }
//
//    public void updatePoint() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
//        for (CheckedPoint checkedPoint : pointsList){
//            checkedPoint.setR (point.getR ());
//            checkedPoint.setResult(calculateResult (point.getR (), checkedPoint.getX (), checkedPoint.getY ()));
//            new CheckedPointService().update(checkedPoint);
//            throw new SQLException ();
//        }
//    }
//
//    public String calculateResult(int r, double x, double y){
//        if (x<=0 & y<=0 & x>=-r & y>=-r/2.0 ){
//            return "Попали";
//        }
//        else if(x>=0 & y>=0 & x<=r/2.0 & y<=r/2.0 & y*y+x*x<=(r/2.0)*(r/2.0)){
//            return "Попали";
//        }
//        else if(x<=0 & y>=0 & x>=-r/1.0 & y<=r/1.0 & x+r/1.0>=y){
//            return "Попали";
//        }
//        else return "Промахнулись";
//    }
//
//    public Point getPoint() {
//        return point;
//    }
//
//    public void setPoint(Point point) {
//        this.point = point;
//    }
//
//    public void setPointsList(List<CheckedPoint> pointsList) {
//        pointsList = pointsList;
//    }
//}
