package us.muit.fs.a4i.test.model.remote;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.model.entities.ReportItem;
import us.muit.fs.a4i.model.remote.GitHubRepositoryEnquirer;

class GithubRepositoryEnquirerTest {
	private static Logger log = Logger.getLogger(GitHubRepositoryEnquirer.class.getName());

	@Test
	void testOpenIssues() {		
		
		ReportItem<Integer> item = null;
		
		GitHubRepositoryEnquirer underTest = null;
		underTest = new GitHubRepositoryEnquirer();
		log.info("Objeto GitHubRepositoryEnquirer creado");
		
		try {
			item = underTest.getMetric("OpenIssues", "manjergon/PracticandoGIT");
			
			
			
		} catch (MetricException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("OpenIssues", item.getName(), "El nombre establecido no es correcto");
		assertEquals(2, item.getValue(), "El valor establecido no es correcto");
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
				item.getDate().toString(), "La fecha establecida no es correcta");
		assertEquals(item.getDescription(), "Número de Issues abiertos en el proyecto",
				"La descripci�n no coincide con la del fichero de configuraci�n");
		assertNull(item.getSource(), "El origen no deber�a estar incluido");
		assertEquals(item.getUnit(), "OpenIssues", "Deber�a incluir las unidades");
	}
	
	@Test
	void testClosedIssues() {

		
		ReportItem<Integer> item = null;
		GitHubRepositoryEnquirer underTest = null;
		underTest = new GitHubRepositoryEnquirer();
		log.info("Objeto GitHubRepositoryEnquirer creado");
		
			try {
				item = underTest.getMetric("ClosedIssues", "manjergon/PracticandoGIT");
			} catch (MetricException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			assertEquals("ClosedIssues", item.getName(), "El nombre establecido no es correcto");
			assertEquals(2, item.getValue(), "El valor establecido no es correcto");
			assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
					item.getDate().toString(), "La fecha establecida no es correcta");
			assertEquals(item.getDescription(), "Número de Issues cerrados en el proyecto",
					"La descripci�n no coincide con la del fichero de configuraci�n");
			assertNull(item.getSource(), "El origen no deber�a estar incluido");
			assertEquals(item.getUnit(), "ClosedIssues", "Deber�a incluir las unidades");


	}

}
