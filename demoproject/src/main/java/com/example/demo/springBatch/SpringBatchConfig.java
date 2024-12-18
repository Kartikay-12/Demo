package com.example.demo.springBatch;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.support.PassThroughItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.controller.EmpController;
import com.example.demo.dao.IEmpRepo;

@Configuration
public class SpringBatchConfig {

	private IEmpRepo empRepo;
	private final PlatformTransactionManager transactionManager;
	private JobRepository jobRepository;
	
	public SpringBatchConfig(IEmpRepo empRepo,PlatformTransactionManager transactionManager,JobRepository jobRepository) {
		this.empRepo=empRepo;
		this.transactionManager=transactionManager;
		this.jobRepository=jobRepository;
	}
	
	private static Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Bean
    public RepositoryItemReader<EmployeeDto> reader() {
        RepositoryItemReader<EmployeeDto> reader = new RepositoryItemReader<>();
        List<EmployeeDto> employees = empRepo.findAll();
        System.out.println("Employees Details---------"+employees);
        reader.setRepository(empRepo);
        reader.setMethodName("findAll"); 
        reader.setPageSize(10);
        reader.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        return reader;
        
    }

	// Processor Bean
	  @Bean
	    public PassThroughItemProcessor<EmployeeDto> processor() {
	        return new PassThroughItemProcessor<>();
	    }

	// Writer Bean
	  @Bean
	    public FlatFileItemWriter<EmployeeDto> writer() {
	        return new FlatFileItemWriterBuilder<EmployeeDto>()
	                .name("csvWriter")
	                .resource(new FileSystemResource("output/Employee.csv"))
	                .delimited()
	                .delimiter(",")
	                .names("id", "name", "address","department")
	                .headerCallback(writer -> writer.write("ID,Name,Address,Department"))
	                .lineAggregator(item -> {
	                logger.info("Writing item: " + item);  
	                return String.format("%d,%s,%s,%s", item.getId(),
	                		item.getName(),
	                		item.getAddress(),
	                		item.getDepartment());  })
	                .build();
	    }

	  @Bean
	    public Step step() {
	        return new StepBuilder("step1", jobRepository)
	                .<EmployeeDto, EmployeeDto>chunk(10, transactionManager)
	                .reader(reader())
	                .processor(processor())
	                .writer(writer())
	                .build();
	    }

	  @Bean
	    public Job job() {
		  logger.info("Starting batch job...");
	        return new org.springframework.batch.core.job.builder.JobBuilder("DataBase to csv", jobRepository)
	                .start(step())
	                .build();
	    }
	
}
