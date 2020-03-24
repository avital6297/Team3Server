//package team1.spring.training;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//
//@Component
//public class Runner implements CommandLineRunner {
//
//    private static final Logger logger = LoggerFactory.getLogger(Runner.class);
//
//    @Autowired
//    private FileRepository fileRepository;
//
//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
//
//        logger.info("initializing users");
//
//        File f1 = new File("Paul", "Smith", "paul.smith@gmail.com");
//        fileRepository.save(f1);
//
//        File f2 = new File("Robert", "Black", "rb34@gmail.com");
//        fileRepository.save(f2);
//
//        File f3 = new File("John", "Doe", "jdoe@gmail.com");
//        fileRepository.save(f3);
//    }
//}
