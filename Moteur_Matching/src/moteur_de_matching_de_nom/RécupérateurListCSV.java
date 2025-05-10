package moteur_de_matching_de_nom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class RécupérateurListCSV implements Recuperateur{
	private String path;

	public RécupérateurListCSV(String path) {
		this.path = path;
	}
	@Override
	public List<Nom> récupérer() {
		try (Stream<String> lines = Files.lines(Paths.get(path))) {
			return lines.skip(1) // Skip the header line
				.map(line -> line.split(","))
				.filter(values -> values.length >= 2)
				.map(values -> new Nom(values[0].trim(), values[1].trim()))
				.toList();
		} catch (IOException e) {
			e.printStackTrace();
			return List.of();
		}
		}
	
		}


