package br.com.jsr352.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.batch.runtime.JobInstance;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class TesteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		jobOperator.start("teste-job", null);

		List<JobInstance> jobInstances = jobOperator.getJobInstances(
				"teste-job", 0, 100000);
		
		PrintWriter out = resp.getWriter();
		for (JobInstance jobInstance : jobInstances) {
			List<JobExecution> jobExecutions = jobOperator
					.getJobExecutions(jobInstance);
			for (JobExecution jobExecution : jobExecutions) {
				
				out.println(
						"Teste do job. #"
								+ jobExecution.getExecutionId()
								+ " com status:"
								+ jobExecution.getBatchStatus());
			}
		}
	}

}
