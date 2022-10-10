package lookieBM.taxitogether;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TaxitogetherApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxitogetherApplication.class, args);
	}

}
