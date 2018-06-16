package me.savushkin.stargate.base.baseApp;

import com.github.javafaker.Faker;
import me.savushkin.stargate.base.baseApp.Services.StorageService;
import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.auth.model.UserRole;
import me.savushkin.stargate.base.baseApp.auth.repository.UserRepository;
import me.savushkin.stargate.base.baseApp.auth.repository.UserRoleRepository;
import me.savushkin.stargate.base.baseApp.command.model.Command;
import me.savushkin.stargate.base.baseApp.command.model.CommandType;
import me.savushkin.stargate.base.baseApp.command.repository.CommandRepository;
import me.savushkin.stargate.base.baseApp.command.repository.CommandTypeRepository;
import me.savushkin.stargate.base.baseApp.mission.repository.MissionRepository;
import me.savushkin.stargate.base.baseApp.planet.model.AddressStarGate;
import me.savushkin.stargate.base.baseApp.planet.model.Shevron;
import me.savushkin.stargate.base.baseApp.planet.repository.AddressStarGateRepository;
import me.savushkin.stargate.base.baseApp.planet.repository.ShevronRepository;
import me.savushkin.stargate.base.baseApp.planet.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.*;

@SpringBootApplication
public class BaseApplication extends SpringBootServletInitializer implements CommandLineRunner {
	private final String DEFAULT_PASS = "$2a$04$Z0s5s9dWwDLqeYuyplbAJem760d9e5gE.7xp.jQn6ANa7SCMb2Iaq"; // derparol
	private Faker faker = new Faker(Locale.forLanguageTag("en"));

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;
	private final CommandRepository commandRepository;
	private final CommandTypeRepository commandTypeRepository;
	private final MissionRepository missionRepository;
	private final ShevronRepository shevronRepository;
	private final AddressStarGateRepository addressStarGateRepository;
	private final ZoneRepository zoneRepository;

	@Autowired
	public BaseApplication(UserRepository userRepository, UserRoleRepository userRoleRepository, CommandRepository commandRepository, CommandTypeRepository commandTypeRepository, MissionRepository missionRepository, ShevronRepository shevronRepository, AddressStarGateRepository addressStarGateRepository, ZoneRepository zoneRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
		this.commandRepository = commandRepository;
		this.commandTypeRepository = commandTypeRepository;
		this.missionRepository = missionRepository;
		this.shevronRepository = shevronRepository;
		this.addressStarGateRepository = addressStarGateRepository;
		this.zoneRepository = zoneRepository;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BaseApplication.class);
	}

	public static void main(String[] args) {
		StorageService storageService = new StorageService();
		try {
			storageService.init();
		} catch(Exception e){

		}

		SpringApplication.run(BaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		populateUsers();
		populatePlanets();
	}

	String generatePhysicalPlanetName() {
		return "P" + faker.number().digits(1) + "X-" + faker.number().digits(4);
	}

	void populateUsers() {
		commandRepository.deleteAll();
		commandTypeRepository.deleteAll();
		userRoleRepository.deleteAll();
		userRepository.deleteAll();

		List<User> users = new ArrayList<>();
		users.add(new User("admin",
				faker.name().firstName(),
				null,
				faker.name().lastName(),
				"Admin",
				DEFAULT_PASS,
				true,
				null));
		users.add(new User("commander",
				faker.name().firstName(),
				null,
				faker.name().lastName(),
				"General",
				DEFAULT_PASS,
				true,
				null));
		users.add(new User("operator",
				faker.name().firstName(),
				null,
				faker.name().lastName(),
				"Sergeant",
				DEFAULT_PASS,
				true,
				null));
		users.add(new User("malp",
				faker.name().firstName(),
				null,
				faker.name().lastName(),
				null,
				DEFAULT_PASS,
				false,
				null));

		for (int i = 0; i < 10; i++) {
			users.add(new User("archaeologist" + i,
					faker.name().firstName(),
					null,
					faker.name().lastName(),
					"Major",
					DEFAULT_PASS,
					true,
					null));
			users.add(new User("geologist" + i,
					faker.name().firstName(),
					null,
					faker.name().lastName(),
					"Major",
					DEFAULT_PASS,
					true,
					null));
			users.add(new User("scout" + i,
					faker.name().firstName(),
					null,
					faker.name().lastName(),
					"Major",
					DEFAULT_PASS,
					true,
					null));
			users.add(new User("diplomat" + i,
					faker.name().firstName(),
					null,
					faker.name().lastName(),
					"Major",
					DEFAULT_PASS,
					true,
					null));
		}

		userRepository.save(users);

		List<UserRole> userRoles = new ArrayList<>();
		User user = userRepository.findByUsername("commander");

		userRoles.add(new UserRole(
				user.getId(),
				"ROLE_USER"
		));
		userRoles.add(new UserRole(
				user.getId(),
				"ROLE_COMMANDER"
		));

		user = userRepository.findByUsername("operator");

		userRoles.add(new UserRole(
				user.getId(),
				"ROLE_USER"
		));
		userRoles.add(new UserRole(
				user.getId(),
				"ROLE_OPERATOR"
		));

		user = userRepository.findByUsername("admin");

		userRoles.add(new UserRole(
				user.getId(),
				"ROLE_USER"
		));
		userRoles.add(new UserRole(
				user.getId(),
				"ROLE_ADMINISTRATOR"
		));

		user = userRepository.findByUsername("malp");

		userRoles.add(new UserRole(
				user.getId(),
				"ROLE_DRONE"
		));

		for (int i = 0; i < 10; i++) {
			user = userRepository.findByUsername("archaeologist" + i);

			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_USER"
			));
			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_SG"
			));
			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_ARCHAEOLOGIST"
			));

			user = userRepository.findByUsername("geologist" + i);

			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_USER"
			));
			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_SG"
			));
			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_GEOLOGIST"
			));

			user = userRepository.findByUsername("scout" + i);

			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_USER"
			));
			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_SG"
			));
			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_SCOUT"
			));

			user = userRepository.findByUsername("diplomat" + i);

			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_USER"
			));
			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_SG"
			));
			userRoles.add(new UserRole(
					user.getId(),
					"ROLE_DIPLOMAT"
			));
		}

		userRoleRepository.save(userRoles);

		List<CommandType> commandTypes = new ArrayList<>();
		commandTypes.add(
				new CommandType(1L, "Археологи", "Изучают полезные ископаемые", null)
		);
		commandTypes.add(
				new CommandType(2L, "Разведывательный отряд", "Разведка новых зон", null)
		);
		commandTypes.add(
				new CommandType(3L, "Дипломат", "Установка дипломатических связей с жителями Зон", null)
		);
		commandTypes.add(
				new CommandType(4L, "Команда поддержки", "Команда быстрого реагирования для поддержки других команд в Зонах в случае угрозу их уничтожения", null)
		);

		commandTypeRepository.save(commandTypes);

		List<Command> commands = new ArrayList<>();

		users = userRepository.findUsersForAddToCommand("ROLE_ARCHAEOLOGIST");
		Command command = new Command("AR-1", commandTypeRepository.findOne(1L), "Главный отряд археологов", new HashSet<User>(users.subList(0, 4)), null);
		commands.add(command);

		users = userRepository.findUsersForAddToCommand("ROLE_GEOLOGIST");
		command = new Command("GEO-1", commandTypeRepository.findOne(2L), "Главный отряд геологов", new HashSet<User>(users.subList(0, 4)), null);
		commands.add(command);

		users = userRepository.findUsersForAddToCommand("ROLE_SCOUT");
		command = new Command("SG-1", commandTypeRepository.findOne(3L), "Главный отряд разведки", new HashSet<User>(users.subList(0, 4)), null);
		commands.add(command);

		users = userRepository.findUsersForAddToCommand("ROLE_DIPLOMAT");
		command = new Command("DIP-1", commandTypeRepository.findOne(3L), "Главный отряд дипломатов", new HashSet<User>(users.subList(0, 4)), null);
		commands.add(command);

		commandRepository.save(commands);
	}

	void populatePlanets() {
		addressStarGateRepository.deleteAll();
		shevronRepository.deleteAll();

		List<Shevron> shevrons = new ArrayList<>();
		Collections.addAll(shevrons,
				new Shevron("Earthnew"),
				new Shevron("Craternew"),
				new Shevron("Virgonew"),
				new Shevron("Bootesnew"),
				new Shevron("Centaurusnew"),
				new Shevron("Libranew"),
				new Shevron("Serpens Caputnew"),
				new Shevron("Normanew"),
				new Shevron("Scorpionew"),
				new Shevron("Cranew"),
				new Shevron("Scutumnew"),
				new Shevron("Sagittariusnew"),
				new Shevron("Aquilanew"),
				new Shevron("Micnew"),
				new Shevron("Capricornnew"),
				new Shevron("Pisces Austrinusnew"),
				new Shevron("Equuleusnew"),
				new Shevron("Aquariusnew"),
				new Shevron("Pegasusnew"),
				new Shevron("Sculptornew"),
				new Shevron("Piscesnew"),
				new Shevron("Andromedanew"),
				new Shevron("Triangulumnew"),
				new Shevron("Ariesnew"),
				new Shevron("Perseusnew"),
				new Shevron("Cetusnew"),
				new Shevron("Taurusnew"),
				new Shevron("Auriganew"),
				new Shevron("Eridanusnew"),
				new Shevron("Orionnew"),
				new Shevron("Canis Minornew"),
				new Shevron("Monocerosnew"),
				new Shevron("Gemininew"),
				new Shevron("Hydranew"),
				new Shevron("Lynxnew"),
				new Shevron("Cancernew"),
				new Shevron("Sextansnew"),
				new Shevron("Leo Minornew"),
				new Shevron("Leonew")
		);

		shevronRepository.save(shevrons);
		shevrons = shevronRepository.findAll();

		List<AddressStarGate> addressStarGates = new ArrayList<>();
		Collections.addAll(addressStarGates,
				new AddressStarGate("ABYDOS", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("APOPHIS'S BASE", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("CAMELOT", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("CASTIANA", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("SAHAL", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("CHULAK", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("CLAVA THESSARA INFINITAS", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("DESTROYERS", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("EARTH", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("EARTH", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("EDORA", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("EURONDA", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("JUNA", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("KALLANA", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("KHEB", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("K'TAU", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("LAND OF LIGHT", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("MARTIN'S HOMEWORLD", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("MARTIN'S HOMEWORLD", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("OTHALA", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1))),
				new AddressStarGate("P2X-555", "P2X-555",
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("P3W-451", "P3W-451",
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("P3X-116", "P3X-116",
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("P3X-118", "P3X-118",
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("P3X-562", "P3X-562",
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("P3X-984", "P3X-984",
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("P9C-372", "P9C-372",
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("PB5-926", "PB5-926",
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("PRACLARUSH TAONAS", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("SANGREAL PLANET", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("TARTARUS", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("TOLLAN", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("TOLLANA", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null),
				new AddressStarGate("UNNAMED PLANET", generatePhysicalPlanetName(),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						shevrons.get(faker.number().numberBetween(0, shevrons.size()-1)),
						null));

		addressStarGateRepository.save(addressStarGates);
	}
}
