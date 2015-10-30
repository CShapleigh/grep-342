import java.util.ArrayList;
import java.util.concurrent.*;

public class CGrep {
  public static void main(String [] args) {
	  final String pattern = args[0];
	  ArrayList<String> files = new ArrayList<String>();
	  for(int i = 1; i < args.length; i++){
		  files.add(args[i]);
	  }
	  final ExecutorService pool = Executors.newFixedThreadPool(3);
	  final ExecutorCompletionService<Found> ecs = new ExecutorCompletionService<>(pool);

	  for(final String file : files){
		  ecs.submit(new Callable<Found>() {
			  @Override
			  public Found call() throws Exception {
				  FileReader fr = new FileReader(file, pattern);
          fr.start();
				  return fr.found;
			  }
		  });
	  }
    
    pool.shutdown();

	  for(int i = 0; i < files.size(); i++){
		  try {
			final Future<Found> future = ecs.take();
			final Found found = future.get();
			System.out.println(found.getFileName());
			for(String line : found.getMatchingLinesInFile()){
				System.out.println(line);
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	  }
  }
}
