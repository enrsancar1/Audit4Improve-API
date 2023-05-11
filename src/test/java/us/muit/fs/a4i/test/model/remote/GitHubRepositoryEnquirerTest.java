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
	
	@Test
	void testMetricCollaboratorCounts() {
		GitHubRepositoryEnquirer underTest = new GitHubRepositoryEnquirer();
		try {
			
		GitHub github = GitHubBuilder.fromEnvironment().build();
		
		try {
		ReportItem<?> newMetric = underTest.getMetric("CollaboratorsCount","enrsancar1/PracticandoGIT");
		
		assertEquals("CollaboratorsCount", newMetric.getName(), "El nombre establecido no es correcto");
		
		assertEquals(1, newMetric.getValue(), "El valor establecido no es correcto");
		
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
				newMetric.getDate().toString(), "La fecha establecida no es correcta");
		
		assertEquals(newMetric.getDescription(), "Número de colaboradores del proyecto",
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

		try {
		ReportItem<?> newMetric = underTest.getMetric("OwnerCommits","enrsancar1/PracticandoGIT");
		
		assertEquals("OwnerCommits", newMetric.getName(), "El nombre establecido no es correcto");
		
		assertEquals(0, newMetric.getValue(), "El valor establecido no es correcto");
		
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
				newMetric.getDate().toString(), "La fecha establecida no es correcta");
		
		assertEquals(newMetric.getDescription(), "Número de commits del propietario del repositorio en el último sprint",
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
		
		try {
		ReportItem<?> newMetric = underTest.getMetric("AllCommits", "enrsancar1/PracticandoGIT");
		
		assertEquals("AllCommits", newMetric.getName(), "El nombre establecido no es correcto");
		
		assertEquals(0, newMetric.getValue(), "El valor establecido no es correcto");
		
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
				newMetric.getDate().toString(), "La fecha establecida no es correcta");
		
		assertEquals(newMetric.getDescription(), "Número de commits totales en el último sprint",
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
