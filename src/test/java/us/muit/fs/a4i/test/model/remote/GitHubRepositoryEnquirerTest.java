package us.muit.fs.a4i.test.model.remote;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.model.entities.ReportItem;
import us.muit.fs.a4i.model.remote.GitHubRepositoryEnquirer;

class GitHubRepositoryEnquirerTest {
	
//Id repositorio = 616960702
	
	@Test
	void testMetricCollaboratorCounts() {
		GitHubRepositoryEnquirer underTest = new GitHubRepositoryEnquirer();
		try {
			
		GitHub github = GitHubBuilder.fromEnvironment().build();
		GHRepository repo = github.getRepository("manjergon/PracticandoGIT");
		String repoId = ""+repo.getId();
		
		try {
		ReportItem<?> newMetric = underTest.getMetric("CollaboratorsCount",repoId);
		
		assertEquals("CollaboratorsCount", newMetric.getName(), "El nombre establecido no es correcto");
		
		assertEquals(0, newMetric.getValue(), "El valor establecido no es correcto");
		
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
				newMetric.getDate().toString(), "La fecha establecida no es correcta");
		
		assertEquals(newMetric.getDescription(), "Colaboradores del proyecto",
				"La descripci�n no coincide con la del fichero de configuraci�n");
		
		assertNull(newMetric.getSource(), "El origen no deber�a estar incluido");
		
		assertEquals(newMetric.getUnit(), "collaborators", "Deber�a incluir las unidades");

		
		}
		catch(MetricException e){
			fail("Error al conseguir la metrica");
			e.printStackTrace();
		}
		}
		catch(IOException e){
			fail("Hubo un error al obtener el repositorio");
		}
	}
	
	@Test
	void testMetricOwnerCommits() {
		GitHubRepositoryEnquirer underTest = new GitHubRepositoryEnquirer();
		try {
			
		GitHub github = GitHubBuilder.fromEnvironment().build();
		GHRepository repo = github.getRepository("manjergon/PracticandoGIT");
		String repoId = ""+repo.getId();
		
		try {
		ReportItem<?> newMetric = underTest.getMetric("OwnerCommits",repoId);
		
		assertEquals("OwnerCommits", newMetric.getName(), "El nombre establecido no es correcto");
		
		assertEquals(3, newMetric.getValue(), "El valor establecido no es correcto");
		
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
				newMetric.getDate().toString(), "La fecha establecida no es correcta");
		
		assertEquals(newMetric.getDescription(), "Commits del dueno del repositorio",
				"La descripci�n no coincide con la del fichero de configuraci�n");
		
		assertNull(newMetric.getSource(), "El origen no deber�a estar incluido");
		
		assertEquals(newMetric.getUnit(), "commits", "Deber�a incluir las unidades");

		
		}
		catch(MetricException e){
			fail("Error al conseguir la metrica");
			e.printStackTrace();
		}
		}
		catch(IOException e){
			fail("Hubo un error al obtener el repositorio");
		}
	}
	
	
	@Test
	void testMetricAllCommits() {
		GitHubRepositoryEnquirer underTest = new GitHubRepositoryEnquirer();
		try {
			
		GitHub github = GitHubBuilder.fromEnvironment().build();
		GHRepository repo = github.getRepository("manjergon/PracticandoGIT");
		String repoId = ""+repo.getId();
		
		try {
		ReportItem<?> newMetric = underTest.getMetric("AllCommits",repoId);
		
		assertEquals("OwnerCommits", newMetric.getName(), "El nombre establecido no es correcto");
		
		assertEquals(0, newMetric.getValue(), "El valor establecido no es correcto");
		
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
				newMetric.getDate().toString(), "La fecha establecida no es correcta");
		
		assertEquals(newMetric.getDescription(), "Commits totales en el ultimo sprint",
				"La descripci�n no coincide con la del fichero de configuraci�n");
		
		assertNull(newMetric.getSource(), "El origen no deber�a estar incluido");
		
		assertEquals(newMetric.getUnit(), "commits", "Deber�a incluir las unidades");

		
		}
		catch(MetricException e){
			fail("Error al conseguir la metrica");
			e.printStackTrace();
		}
		}
		catch(IOException e){
			fail("Hubo un error al obtener el repositorio");
		}
	}

}
