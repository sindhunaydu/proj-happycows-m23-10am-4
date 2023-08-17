package edu.ucsb.cs156.happycows.services.jobs;

@FunctionalInterface
public interface JobContextConsumer {
  void accept(JobContext c) throws Exception;
}
