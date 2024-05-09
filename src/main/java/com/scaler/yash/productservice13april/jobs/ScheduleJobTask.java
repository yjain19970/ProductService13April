package com.scaler.yash.productservice13april.jobs;

import com.scaler.yash.productservice13april.model.Product;
import com.scaler.yash.productservice13april.repository.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ScheduleJobTask {
    private ProductRepository productRepository;

    public ScheduleJobTask(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //sec, min, hour,dayofMonth,Month,WeekDay
    // * anything
    @Scheduled(cron = "0 * * * * *") // every minute
    public void executeJob() {
        Optional<Product> product = productRepository.findById(1);
        if (product.isPresent()) {
            System.out.println("Fetched Product with Id:" + product.get().getId());
        }
    }
}
