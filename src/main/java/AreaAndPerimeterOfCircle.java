public class AreaAndPerimeterOfCircle {

    public static void main(String [] a)
    {
        Area area = new Area(12);
        Thread thread1 = new Thread(area);
        thread1.start();
        Perimeter perimeter = new Perimeter(12);
        Thread thread2 = new Thread(perimeter);
        thread2.start();
    }
}
class Perimeter implements Runnable{
    double radius;
    public Perimeter(double r)
    {
        this.radius=r;
    }
    public void run(){
        double perimeter=this.radius*3.14;
        System.out.println("The area is "+perimeter*2);
    }
}
class Area implements Runnable{
    double radius;
    public Area(double r)
    {
        this.radius=r;
    }
    public void run(){
        double area=this.radius*this.radius;
        System.out.println("The area is "+area*3.14);
    }
}