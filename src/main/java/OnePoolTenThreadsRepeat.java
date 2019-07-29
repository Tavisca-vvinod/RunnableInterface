import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

public class OnePoolTenThreadsRepeat {
    public static void main(String [] a) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> call=new TestCallable();
        for (int i = 0; i < 10; i++) {
                Future<String> future=service.submit(call);
                list.add(future);
        }
        Function<Future<String>,String> function = (f)->{
            String name="";
            try {
                name= f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return name;
        };
        list.stream().map(function).forEach(System.out::println);
        for(Future<String> f : list)
        {
            System.out.println(System.currentTimeMillis()+"::::"+f.get());
        }
        service.shutdown();
    }
}

class TestCallable implements Callable<String> {
    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return Thread.currentThread().getName();
        }
}