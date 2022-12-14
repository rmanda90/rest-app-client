package com.mpk.samples.restappclient.stream.student;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Spring cloud streams {@link Processor} which sends out a {@link Student_id} which further needs to be enriched.
 */
public interface StudentProcessor {

	public static final String OUTPUT = "student-ingestion-stream";
//	public static final String INPUT = "student-inbound-stream";
//
//	@Input(INPUT)
//	SubscribableChannel receiveStudent();

	@Output(OUTPUT)
	MessageChannel  publishStudent();
}
