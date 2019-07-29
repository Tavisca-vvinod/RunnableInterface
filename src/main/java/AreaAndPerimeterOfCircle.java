import java.util.concurrent.*;

public class AreaAndPerimeterOfCircle {

    public static void main(String [] a) throws ExecutionException, InterruptedException {
        ExecutorService service=Executors.newFixedThreadPool(2);
        Future<Double> f1=service.submit(new Area(12.00));
        Future<Double> f2=service.submit(new Perimeter(12.00));
        System.out.println("The area is "+f1.get());
        System.out.println("The perimeter is "+f2.get());
        service.shutdown();
    }
}
class Perimeter implements Callable<Double>{
    double radius;
    public Perimeter(double r)
    {
        this.radius=r;
    }
    @Override
    public Double call() throws Exception{
        double perimeter=this.radius*3.14;
        return (perimeter*2);
    }
}
class Area implements Callable<Double>{
    double radius;
    public Area(double r)
    {
        this.radius=r;
    }
    @Override
    public Double call() throws Exception{
        double area=this.radius*this.radius;
        return (area*3.14);
    }
}