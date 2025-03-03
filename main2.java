import java.io.*;
import java.nio.file.*;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DataProcessor {
}


class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);


    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try  {
            data = Files.readAllLines(Paths.get(source));
            System.out.println("Данные загружены из файла: " + source);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке данных из файла: " + e.getMessage());
        }
    }


    public void processData() {
        List<Future<Void>> futures = new ArrayList<>();
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    futures.add(executorService.submit(() -> {
                        try {
                            synchronized (data) {
                                List<String> result = new ArrayList<>();
                                for (String item : data) {
                                    String processed = (String) method.invoke(processor, item);
                                    if (processed != null) {
                                        result.add(processed);
                                    }
                                }
                                data.clear();
                                data.addAll(result);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }));
                }
            }
        }

        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Данные обработаны параллельно.");
    }

    public void saveData(String destination) {
        try {
            Files.write(Paths.get(destination), data);
            System.out.println("Данные сохранены в файл: " + destination);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных в файл: " + e.getMessage());
        }
    }

    public void shutdown() {
        executorService.shutdown();

    }
}


class DataFilter {
    @DataProcessor
    public String filterShortWords(String data) {
        return data.length() > 5 ? data : null;
    }
}

class DataTransformer {
    @DataProcessor
    public String toUpperCase(String data) {
        return data.toUpperCase();
    }
}

class DataAggregation{
    @DataProcessor
    public String addPrefix(String data) {
        return "Processed: " + data;
    }
}

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        dataManager.registerDataProcessor(new DataFilter());
        dataManager.registerDataProcessor(new DataTransformer());
        dataManager.registerDataProcessor(new DataAggregation());

        dataManager.loadData("source.txt");

        dataManager.processData();

        dataManager.saveData("destination.txt");

        dataManager.shutdown();
    }
}
